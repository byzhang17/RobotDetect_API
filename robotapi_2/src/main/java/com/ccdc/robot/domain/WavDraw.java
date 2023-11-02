package com.ccdc.robot.domain;

import java.util.ArrayList;
import java.util.List;



public class WavDraw{

    //显示时域波形
	public static List<Double[]> ShowWave(String filename) {
		WaveFileReader reader = new WaveFileReader(filename + "/out.wav");
		String[] pamss = new String[] { "-r", "-g", "-b" };
		List<Double[]> pos = new ArrayList<>();
		if (reader.isSuccess()) {
			for (int i = 0; i < reader.getNumChannels(); ++i) {//双声道循环------------
				// 获取i声道数据
//				int i=0;//仅用单声道--------
				int N = 65536;//前多少点dft
				int[] data = reader.getData()[i];
				int length = data.length;
				int[] partData = new int[N];
				for(int j = 0;j<length;j++) {
					if((j*N+N)>length) {
						break;
					}
					System.arraycopy(data, N*j, partData, 0, N);

					// 绘图
                    // XYSeriesCollection dataset = new XYSeriesCollection( );
					// XYSeries firefox = new XYSeries( "Firefox" );          
      				// firefox.add( 1.0 , 1.0 );
					for(int m = 0; m < N/2; m++)
					{
						pos.add(new Double[]{Double.valueOf(m / (N / 2.0)),Double.valueOf(partData[m])});
					}
					// dataset.addSeries(firefox);					
					// JFreeChart xylineChart = ChartFactory.createXYLineChart(
					// 	"时域" ,
					// 	"Category" ,
					// 	"Score" ,
					// 	dataset,
					// 	PlotOrientation.VERTICAL ,
					// 	true , true , false);

					// ChartFrame chartFrame = new ChartFrame("Test", xylineChart);
					// chartFrame.pack();
					// chartFrame.setVisible(true);
					// //
					// int width = 640; /* Width of the image */
      				// int height = 480; /* Height of the image */ 
      				// File XYChart = new File( "XYLineChart.jpeg" ); 
      				// //ChartUtilities.saveChartAsJPEG( XYChart, xylineChart, width, height);
					// try{
					// 	ChartUtils.saveChartAsJPEG(XYChart, xylineChart, width, height);
					// }
					// catch(Exception e){
					// }	
					return pos;
				}
			}//双声道循环------
//			Plot.hold_off();
		} else {
			System.err.println(filename + "不是一个正常的wav文件");
		}
		return pos;
	}
}
