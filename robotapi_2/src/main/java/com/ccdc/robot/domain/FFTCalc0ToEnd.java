package com.ccdc.robot.domain;

import java.util.ArrayList;
import java.util.List;




public class FFTCalc0ToEnd {

	//显示频域信息
    public static List<Double[]> ShowFre(String filename) {
	//从0开始一次计算2048点FFT
		WaveFileReader reader = new WaveFileReader(filename + "/out.wav");
		String[] pamss = new String[] { "-r", "-g", "-b" };
		List<Double[]> pos = new ArrayList<>();
		if (reader.isSuccess()) {
				int i=0;//仅用单声道--------
				int N = 65536;//每次计算FFT点的个数
				double[] x = new double[N/2];
				
				for(int j =0; j < N/2; j++)
				{
					x[j] = j * (double)reader.getSampleRate() / N;
				}
				int[] data = reader.getData()[i];
				int length = data.length;
				System.out.println(length);
				Complex[] complexData = Util.changeToComplex(data);
				
//				Complex[] dftData = DFT.dft(complexData, N);
				long t1=System.currentTimeMillis();
//					int j=0;//测试用
				for(int j = 0;j<length;j++) {
					if((j*N+N)>length) {
						break;
					}
					Complex[] dftData = FFT.myFFT(complexData,j*N,N);
					double[] result = Util.returnAbsData(Util.returnToDouble(dftData));
					double[] y = new double[N/2];
					System.arraycopy(result, 0, y, 0, N/2);
					try {
						Thread.sleep(140);//调整合适的休眠时间，使频谱与歌曲匹配
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						throw new RuntimeException(e);
					}
					// 绘图
					//Plot.plot(x, y, pamss[i % pamss.length]);
					
					// XYSeriesCollection dataset = new XYSeriesCollection( );
					// XYSeries firefox = new XYSeries( "Firefox" );          
      				// firefox.add( 1.0 , 1.0 );
					for(int m = 0; m < N/2; m++)
					{
						pos.add(new Double[]{Double.valueOf(x[m]),Double.valueOf( 20 * Math.log10(y[m]))});
						//firefox.add(x[m], y[m]);
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
					//
					// int width = 640; /* Width of the image */
      				// int height = 480; /* Height of the image */ 
      				// File XYChart = new File( "XYLineChart.jpeg" ); 
      				// //ChartUtilities.saveChartAsJPEG( XYChart, xylineChart, width, height);
					// try{
					// 	ChartUtils.saveChartAsJPEG(XYChart, xylineChart, width, height);
					// }
					// catch(Exception e){
					return pos;
					// }	
				}	
//				}//双声道循环------
//				Plot.hold_off();
		} else {
			System.err.println(filename + "不是一个正常的wav文件");
		}
		return pos;
	}
}
