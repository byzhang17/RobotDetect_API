package com.ccdc.robot;

import com.ccdc.robot.callback.TaskCallback;
import com.ccdc.robot.domain.*;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import javafx.scene.shape.Rectangle;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.ini4j.Ini;
import org.opencv.core.CvType;
// import org.opencv.core.CvType;
// import org.opencv.imgcodecs.Imgcodecs;
// import org.opencv.imgproc.Imgproc;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.bytedeco.javacpp.opencv_calib3d.LMSolver.Callback;

// import org.opencv.core.Mat;
// import org.opencv.imgcodecs.Imgcodecs;
// import org.opencv.imgproc.Imgproc;



import java.io.*;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Robot_API {

	// static
	// {
	// 	Runnable taskn = new Runnable() {
	// 		@Override
	// 		public void run() {
	// 			// 函数要执行的代码
	//			StartDetectService();
	// 		}
	// 	};

	// 	ExecutorService executor = Executors.newSingleThreadExecutor();

    //     // 提交任务给线程池执行
    //     executor.submit(taskn);
	// }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
// 		List<Integer> id = new ArrayList<>(Arrays.asList(1,2));

// 		//String result = getRobotStatus("192.168.33.158").toString();
// 		String ss = "{\"ip\":\"192.168.33.158\",\"taskId\":57,\"initParam\":{\"pan\":170,\"tilt\":60,\"zoom\":20},\"taskParamList\":[{\"pointId\":34,\"locationId\":2,\"itemList\":[{\"itemId\":40,\"pan\":30,\"tilt\":30,\"zoom\":25,\"residenceTime\":30,\"shotState\":true,\"recordingTime\":30}]},{\"pointId\":35,\"locationId\":1,\"itemList\":[{\"itemId\":41,\"pan\":30,\"tilt\":30,\"zoom\":25,\"residenceTime\":30,\"shotState\":true,\"recordingTime\":30}]},{\"pointId\":36,\"locationId\":6,\"itemList\":[{\"itemId\":42,\"pan\":30,\"tilt\":30,\"zoom\":25,\"residenceTime\":30,\"shotState\":true,\"recordingTime\":30}]}]}";
// ;		//JSONObject.toBean();
// 		JSONObject obj = JSONUtil.toBean(ss, JSONObject.class);
// 		InitParam param = new InitParam();
// 		List<TaskParam> param2 = new ArrayList<>();
// 		List<TaskItemParam> test = new ArrayList<>();

// 		TaskItemParam temp = new TaskItemParam();
// 		temp.setItemId(40l);
// 		temp.setPan(90f);
// 		temp.setTilt(0f);
// 		temp.setZoom(1f);
// 		temp.setLifter(1.6f);
// 		temp.setRecordingTime(30);
// 		temp.setResidenceTime(35);
// 		temp.setShotState(true);

// 		TaskItemParam temp5 = new TaskItemParam();
// 		temp5.setItemId(40l);
// 		temp5.setPan(-90f);
// 		temp5.setTilt(0f);
// 		temp5.setZoom(15f);
// 		temp5.setLifter(1.6f);
// 		temp5.setRecordingTime(30);
// 		temp5.setResidenceTime(35);
// 		temp5.setShotState(true);


// 		List<TaskItemParam> temp2 = new ArrayList<>();
// 		List<TaskItemParam> temp3 = new ArrayList<>();
// 		temp2.add(temp);
// 		temp3.add(temp5);

// 		param.setPan(90f);
// 		param.setTilt(0f);
// 		param.setFliter(1.1f);

// 		TaskParam task = new TaskParam();
// 		task.setItemList(temp2);
// 		task.setLocationId(1001);
// 		task.setPointId(34l);
// 		param2.add(task);

// 		TaskParam task1 = new TaskParam();
// 		task1.setItemList(temp3);
// 		task1.setLocationId(203);
// 		task1.setPointId(35l);
// 		param2.add(task1);
// 		//SetPanTiltPosture("10.255.22.158",90f,20f,2f);

		

// 		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
// 		Date date = new Date();
// 		String rgbpath = "D:\\Source\\image\\" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpeg";
		

// 		List<Integer> open_doors = Arrays.asList(1513, -1);

// 		List<Integer> open_doors1 = Arrays.asList(200, 400, 700, 216, 416, 716, 1000, 1016, 1200, 1216, 1500, 1516);
// 		JSONObject result;
// 		//start_opendoor("127.0.0.1", "3333", "10.255.3.212");

// 		//postMove(rgbpath, open_doors1.get(0), open_doors1);

// 		// for (int i = 0; i < open_doors.size(); i++) {
// 		// 	postMove("10.255.3.212", open_doors.get(i), open_doors1);
// 		// 	try{
// 		// 						Thread.sleep(5000);
// 		// 						}
// 		// 						catch(Exception e)
// 		// 						{
// 		// 							throw new RuntimeException(e);
// 		// 						}
// 		// 	while(true){
// 		// 					result = (JSONObject)getRobotStatus("10.255.3.212");
// 		// 					JSONObject data = (JSONObject)result.get("data");
// 		// 					String state = (String)data.get("state");

// 		// 					if((state.equals("StandingBy"))|| (state.equals("Charging")))
// 		// 					{
// 		// 						break;
// 		// 					}
// 		// 					else
// 		// 					{
// 		// 						try{
// 		// 							Thread.sleep(1500);
// 		// 						}
// 		// 						catch(Exception e)
// 		// 						{
// 		// 							throw new RuntimeException(e);
// 		// 						}
// 		// 					}
// 		// 	}

// 		// }

// 		//postMove("10.255.3.212",-1 , open_doors1);

// 		// set_ctrl_lifter("10.255.3.212",1.6f);

// 		// try{
// 		// 							Thread.sleep(3000);
// 		// 						}
// 		// 						catch(Exception e)
// 		// 						{
// 		// 							throw new RuntimeException(e);
// 		// 						}
// 		//JSONObject res = SetPanTiltPosture("10.255.3.213",90f,0f,1f);

// 		//System.out.println(res);

// 		//JSONObject res = getRoutePlan("10.255.3.212",Arrays.asList(201,304),0.4);
// 		//getRGB("10.255.3.213",rgbpath);

// 		//StartTask("10.255.3.212","10.255.3.213",1l,obj.getLong("taskId"),param,param2,1,open_doors1);		//String result = getRobotStatus("192.168.43.158").toString();
//       	//switch_fill_light("10.255.3.213",true);
		
// 		//postDetectlight("127.0.0.1","D:\\Source\\image\\2023_11_29_09_54_20.jpeg","D:\\Source\\result","3333");

// 		//getAudio("10.255.3.213","D:/",false);
// 		//getMaxtemp("10.255.3.212");
// 		// byte[] res = getRGBPicture("10.255.3.213",false);
// 		// System.out.println(res[500]);
// 		JSONObject jsonObject = new JSONObject();
// 		List<Float> result_max = new ArrayList<>(); 
// 		List<Float> result_min = new ArrayList<>(); 
// 		List<Integer> result_x = new ArrayList<>(); 
// 		List<Integer> result_y = new ArrayList<>();
// 		byte[] buffer = new byte[1024 * 1024];
// 		File file = new File("C:\\Users\\张本熠\\Documents\\WeChat Files\\wxid_ldn8y4bhvtag22\\FileStorage\\File\\2023-12\\shot_heatmap");
// 		int bytesRead = 0;
// 		try {
// 			FileInputStream fis = new FileInputStream(file);
// 			ByteArrayOutputStream bos = new ByteArrayOutputStream();
// 			int len = 0;
// 			while ((len = fis.read(buffer)) != -1) {
// 				bos.write(buffer, 0, len);
// 				bytesRead += len;
// 			}
// 			fis.close();
// 			bos.close();
// 		} catch (Exception e) {
// 			// TODO: handle exception
// 		}
        
//         short[] shortValue = new short[bytesRead / 2];
// 		for (int i = 0; i < shortValue.length; i++) {
// 			shortValue[i] = (short) ((buffer[i * 2] & 0xff) | ((buffer[i * 2 + 1] & 0xff)) << 8);
// 		}
// 		int width = Short.toUnsignedInt(shortValue[0]);
// 		int hight = Short.toUnsignedInt(shortValue[1]);
// 		float slope = Short.toUnsignedInt(shortValue[2]);
// 		float offset = Short.toUnsignedInt(shortValue[3]);

// 		short[][] pointValue = new short[hight][width];
		
// 		for(int n = 0; n < hight; n++)
// 		{
// 			for(int m = 0; m < width; m++)
// 			{
// 				pointValue[n][m] = shortValue[4 + n*width + m];
// 			}
// 		}

// 		for (int i = 0; i < hight; i += hight/3) {
// 			for (int j = 0; j < width - 1; j += width/3) {
// 				int subHeight = hight/3;
// 				int subWidth = width/3;
// 				short[][] subArr = new short[subHeight][subWidth];
// 				for (int k = 0; k < subHeight; k++) {
// 					for (int l = 0; l < subWidth; l++) {
// 						subArr[k][l] = pointValue[i+k][j+l];
// 					}
// 				}
// 				float maxValue = 0;
// 				float minValue = 65535;
// 				for (int k = 0; k < subHeight; k++) {
// 					for (int l = 0; l < subWidth; l++) {
// 						if (subArr[k][l] > maxValue) {
// 							maxValue = subArr[k][l];
// 						}
// 					}
// 				}
// 				List<Integer> x = new ArrayList<>();
// 				List<Integer> y = new ArrayList<>();
// 				int sum_x = 0;
// 				int sum_y = 0;
// 				int closest_max = 0;
// 				int closest_min = 0;
// 				int min_dis = 0;
// 				for (int k = 0; k < subHeight; k++) {
// 					for (int l = 0; l < subWidth; l++) {
// 						if (subArr[k][l] == maxValue) {
// 							x.add(k + i);
// 							y.add(j + l);
// 						}
// 					}
// 				}
// 				for (int num : x) {
// 					sum_x += num;
// 				}
// 				sum_x = sum_x / x.size();

// 				for (int num : y) {
// 					sum_y += num;
// 				}
// 				sum_y = sum_y / y.size();

// 				min_dis = Math.abs(x.get(0) - sum_x) + Math.abs(y.get(0) - sum_y);
// 				for(int m = 0; m < x.size(); m++)
// 				{
// 					if(Math.abs(x.get(m) - sum_x) + Math.abs(y.get(m) - sum_y) < min_dis)
// 					{
// 						min_dis = Math.abs(x.get(m) - sum_x) + Math.abs(y.get(m) - sum_y);
// 						closest_max = m;
// 					}
// 				}

// 				result_x.add(x.get(closest_max));
// 				result_y.add(y.get(closest_max));

// 				x.clear();
// 				y.clear();
// 				sum_x = 0;
// 				sum_y = 0;
// 				min_dis = 0;

// 				for (int k = 0; k < subHeight; k++) {
// 					for (int l = 0; l < subWidth; l++) {
// 						if (subArr[k][l] < minValue) {
// 							minValue = subArr[k][l];
// 						}
// 					}
// 				}

// 				for (int k = 0; k < subHeight; k++) {
// 					for (int l = 0; l < subWidth; l++) {
// 						if (subArr[k][l] == minValue) {
// 							x.add(k + i);
// 							y.add(j + l);
// 						}
// 					}
// 				}

// 				for (int num : x) {
// 					sum_x += num;
// 				}
// 				sum_x = sum_x / x.size();

// 				for (int num : y) {
// 					sum_y += num;
// 				}
// 				sum_y = sum_y / y.size();
// 				min_dis = Math.abs(x.get(0) - sum_x) + Math.abs(y.get(0) - sum_y);
// 				for(int m = 0; m < x.size(); m++)
// 				{
// 					if(Math.abs(x.get(m) - sum_x) + Math.abs(y.get(m) - sum_y) < min_dis)
// 					{
// 						min_dis = Math.abs(x.get(m) - sum_x) + Math.abs(y.get(m) - sum_y);
// 						closest_min = m;
// 					}
// 				}
// 				result_x.add(x.get(closest_min));
// 				result_y.add(y.get(closest_min));



// 				result_max.add(maxValue / (slope + offset));
// 				result_min.add(minValue / (slope + offset));

// 			}
// 		}

// 		System.out.println(result_max + "\n");
// 		System.out.println(result_min + "\n");
// 		System.out.println(result_x + "\n");
// 		System.out.println(result_y + "\n");

// 		jsonObject.put("maxtemp", result_max);
// 		jsonObject.put("mintemp", result_min);
// 		jsonObject.put("result_x", result_x);
// 		jsonObject.put("result_y", result_y);


// 		JSONArray result_max_1 = (JSONArray)jsonObject.get("maxtemp"); 
// 		JSONArray result_min_1 = (JSONArray)jsonObject.get("mintemp"); 
// 		JSONArray result_x_1 = (JSONArray)jsonObject.get("result_x"); 
// 		JSONArray result_y_1 = (JSONArray)jsonObject.get("result_y");
// 		BufferedImage buffImg = null;
// 		try {
// 			File input = new File("C:\\Users\\张本熠\\Desktop\\shot_heatmap_4.jpeg");
// 		 	buffImg = ImageIO.read(input);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		Graphics g = buffImg.getGraphics();

// 		g.setColor(Color.GRAY);
// 		g.drawLine(213, 0, 213, 480);
// 		g.drawLine(426, 0, 426, 480);
// 		//g.drawLine(384, 0, 384, 480);
// 		//g.drawLine(512, 0, 512, 480);
// 		g.drawLine(0, 160, 640, 160);
// 		g.drawLine(0, 320, 640, 320);

// 		g.setColor(Color.RED);
// 		g.drawLine(213, 160, 426, 160);
// 		g.drawLine(213, 320, 426, 320);
// 		g.drawLine(213, 160, 213, 320);
// 		g.drawLine(426, 160, 426, 320);

// 		for(int i = 0;i < result_max.size(); i++)
// 		{
// 			double temp_max = (double)result_max_1.get(i);
// 			double temp_min = (double)result_min_1.get(i);

// 			int x_max = (int)result_x_1.get(i * 2);
// 			int y_max = (int)result_y_1.get(i * 2);
// 			int x_min = (int)result_x_1.get(i * 2 + 1);
// 			int y_min = (int)result_y_1.get(i * 2 + 1);

			
// 			g.setColor(Color.GREEN);
// 			g.drawRect(y_max - 10, x_max - 10, 20, 20);
// 			g.setFont(new Font("宋体", Font.BOLD, 20));
// 			g.drawString(String.valueOf(temp_max), y_max  - 10 , x_max  - 10 + 20);

// 			g.setColor(Color.YELLOW);
// 			g.drawRect(y_min -10, x_min - 10, 20, 20);
// 			g.setFont(new Font("宋体", Font.BOLD, 20));
// 			g.drawString(String.valueOf(temp_min), y_min -10 , x_min - 10 + 20);

// 		}
// 		g.dispose();
// 		try {
// 			File output = new File("C:\\Users\\张本熠\\Desktop\\out.jpg");
// 			ImageIO.write(buffImg, "jpg", output);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
		
	}

	//发送检测指令(ok)
	public static JSONObject postDetectlight(String ip,String image_path,String save_path,String port){

		String url = "http://" + ip + ":"+ port + "/predictlight";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("path", image_path);
		jsonObject2.put("result", save_path);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

	//发送开门指令(ok)
	public static JSONObject start_opendoor(String ip, String port, String ip2){

		String url = "http://" + ip + ":"+ port + "/open_door_start";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("ip", ip2);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

	//停止开门指令
	public static JSONObject stop_opendoor(String ip, String port){

		String url = "http://" + ip + ":"+ port + "/open_door_stop";
		JSONObject jsonObject2 = new JSONObject();
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}	

	//巡检点合法性检查
	public static JSONObject check_goals(String ip, List<Integer> goals){
		 String url = "http://" + ip + ":35181/beepatrol/check_goals";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("goals", goals);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

	//启动颗粒物计数采样
	public static JSONObject enable_particle_counter(String ip, int id, int delay_time, int sample_time){
	    String url = "http://" + ip + ":35182/beepatrol/enable_particle_counter";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("id", id);
		jsonObject2.put("delay_time", delay_time);	
		jsonObject2.put("sample_time", sample_time);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

    //获取机器人状态数据(ok)
    public static JSONObject getRobotStatus(String ip){
        String url = "http://" + ip + ":35181/beepatrol/status";
        JSONObject result = Robot_API.get(url);
        return result;
    }

	//获取移动路线图信息(ok)
    public static JSONObject getMapPoints(String ip){
        String url = "http://" + ip + ":35181/beepatrol/roadmap";
        JSONObject result = Robot_API.get(url);
        return result;
    }

	//回到充电桩
	public static void goCharging(String ip, List<Integer> open_doors,List<Integer> route){
		int code = 0;
		String msg = "";
		JSONObject result = new JSONObject();
		for(int s = route.size() - 1; s >= 0; s--)
		{
			//发送移动命令
			result = postMove(ip, route.get(s), open_doors);

			try{
				Thread.sleep(3000);
			}
			catch(Exception e)
			{
				throw new RuntimeException(e);
			}
			//等待移动完成
			while(true){
				result = (JSONObject)getRobotStatus(ip);
				JSONObject data = (JSONObject)result.get("data");
				String state = (String)data.get("state");
				if((int)result.get("code") != 0){
					code = (int)result.get("code");
					msg = (String)result.get("msg");
				}
				if((state.equals("StandingBy"))|| (state.equals("Charging")))
				{
					break;
				}
				else
				{
					try{
						Thread.sleep(1500);
					}
					catch(Exception e)
					{
						throw new RuntimeException(e);
					}
				}
			}
		}
		result = postMove(ip, -1, open_doors);

		while(true){
			result = (JSONObject)getRobotStatus(ip);
			JSONObject data = (JSONObject)result.get("data");
			String state = (String)data.get("state");
			if((int)result.get("code") != 0){
				code = (int)result.get("code");
				msg = (String)result.get("msg");
			}
			if((state.equals("Charging")))
			{
				break;
			}
			else
			{
				try{
					Thread.sleep(1500);
				}
				catch(Exception e)
				{
					throw new RuntimeException(e);
				}
			}
		}
	}

	//获取路径和时间信息(ok)
	@SuppressWarnings("unchecked")
    public static JSONObject getRoutePlan(String ip, List<Integer> id, Double speed,List<Integer> open_doors){
        String url = "http://" + ip + ":35181/beepatrol/plan";
		List<Integer> Route = new ArrayList<>();
		double time = 0;
		double denstense = 0;
		JSONArray path = new JSONArray();
        //JSONObject result = Robot_API.get(url);
		for(int i = 0; i < id.size() - 1; i++){
    		int  from = id.get(i);
    		int  to = id.get(i + 1);
			//List<Integer> open_doors = Arrays.asList(200, 400, 700, 216, 416, 716, 1000, 1016, 1200, 1216, 1500, 1516);
			//open_doors.clear();
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("from", from);
			jsonObject2.put("to", to);
			jsonObject2.put("open_doors", open_doors);
			jsonObject2.put("velocity", speed);

			JSONObject result = Robot_API.post(jsonObject2, url);

			JSONObject data = (JSONObject)result.get("data");

			time = time + (double)data.get("time");
			
			JSONArray current = (JSONArray)data.get("path");
			
			for( int j = 0; j < current.size(); j++)
			{
				JSONObject boj = (JSONObject)current.get(j);
				if(j == 1 )
				{
					JSONObject obj2 = (JSONObject)current.get(0);
					if((int)boj.get("id") == (int)obj2.get("id"))
					continue;
				}
					
				path.add(current.get(j));
			}

			if(i != id.size() - 2)
			{
				path.remove(path.size() - 1);
			}
		}
		for(int i = 0; i < path.size() - 1; i++){
			JSONObject cur = (JSONObject)path.get(i);
			JSONObject next = (JSONObject)path.get(i+1);
			denstense = denstense + Math.sqrt(Math.pow((double)cur.get("x") -(double)next.get("x"),2) + Math.pow((double)cur.get("y") -(double)next.get("y"),2));
		}
		denstense = denstense * 0.03;

		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("path",path);
		jsonObject1.put("time",time);
		jsonObject1.put("denstense",denstense);
        return jsonObject1;
    }

	//发送移动指令(ok)
	public static JSONObject postMove(String ip, int id, List<Integer> open_doors){
		String url = "http://" + ip + ":35181/beepatrol/move";
		//List<Integer> open_doors = Arrays.asList(200, 400, 700, 216, 416, 716, 1000, 1016, 1200, 1216, 1500, 1516);
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("goal", id);
		jsonObject2.put("open_doors", open_doors);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

	//发送停止移动指令(ok)
	public static JSONObject postStopMove(String ip){
		String url = "http://" + ip + ":35181/beepatrol/stop";
		JSONObject jsonObject2 = new JSONObject();
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

	//发送人工接管机器人(ok)
	public static JSONObject postTakeOver(String ip){
		String url = "http://" + ip + ":35181/beepatrol/start_taking_over";
		JSONObject jsonObject2 = new JSONObject();
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

	//退出人工接管,参数是否与充电桩对好(ok)
	public static JSONObject postStopTakeOver(String ip,Boolean manual_docked){
		String url = "http://" + ip + ":35181/beepatrol/stop_taking_over";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("manual_docked",manual_docked);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

	//清除错误(ok)
	public static JSONObject clearError(String ip){
		String url = "http://" + ip + ":35181/beepatrol/clear_error";
		JSONObject jsonObject2 = new JSONObject();
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

	//启用/禁用自主移动(?)
	public static JSONObject EnableAutoMove(String ip, Boolean enable){
		String url = "http://" + ip + ":35181/beepatrol/enable_base";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("enable", enable);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

	//设置自主移动最大速度(ok)
	public static JSONObject setMaxSpeed(String ip, double speed){
		String url = "http://" + ip + ":35181/beepatrol/set_vel_limit";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("value", speed);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}	

	//控制升降高度(0.1-2.2)
	public static JSONObject set_ctrl_lifter(String ip, Float height){
		String url = "http://" + ip + ":35181/beepatrol/ctrl_lifter";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("height", height);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

	//开关补光灯
	public static JSONObject switch_fill_light(String ip, Boolean on_off){
		String url = "http://" + ip + ":35182/beepatrol/switch_fill_light";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("turn_on", on_off);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}	

	//返回机器人云台状态
	public static JSONObject getPan_tilt(String ip){
        String url = "http://" + ip + ":35182/beepatrol/pan_tilt";
        JSONObject result = Robot_API.get(url);
        return result;
	}

	//获取地图标识
	public static JSONObject getMapUID(String ip,int id){
		String url = "http://" + ip + ":35181/beepatrol/map_uid";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("id", id);
		JSONObject jsStr = null;
		String result = "";
		URI uri = null;
		
		try{
			uri = new URIBuilder(url)
					.setParameter("id", String.valueOf(id)).build();
		}
		catch(URISyntaxException e)
		{
			e.printStackTrace();
		}
		
		HttpGet get = new HttpGet(uri);
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(5000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(5000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			String param = URLEncoder.encode(jsonObject2.toString(), "UTF-8");
			//get.setURI(URI.create(path));
			HttpResponse response = httpClient.execute(get);	
			
			result = getHttpEntityContent(response).toString();

    		jsStr = JSONObject.fromObject(result);
			
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				 result = "服务器异常";
			}
			
		} catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//get.abort();
		}
		return  jsStr;
	}

	//查询外设状态信息（ok)
	public static JSONObject getPeripheralStatus(String ip){
        String url = "http://" + ip + ":35182/beepatrol/peripheral/status";
        JSONObject result = Robot_API.get(url);
        return result;
	}

	//启动颗粒物计数采样(ok)
	public static JSONObject enableParticleCounter(String ip, Integer id){
		String url = "http://" + ip + ":35182/beepatrol/enable_particle_counter";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("id", id);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

	//开关二氧化硫检测仪(ok)
	public static JSONObject enableswitch_so2(String ip, Boolean on_off){
		String url = "http://" + ip + ":35182/beepatrol/switch_so2";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("on", on_off);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

	//开关零气发生器(ok)
	public static JSONObject enableZero_air_gen(String ip, Boolean on_off){
		String url = "http://" + ip + ":35182/beepatrol/switch_zero_air_gen";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("on", on_off);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}

	//启动二氧化硫检测仪零气校准(ok)
	public static JSONObject enablecalibrate_so2(String ip){
		String url = "http://" + ip + ":35182/beepatrol/calibrate_so2";
		JSONObject jsonObject2 = new JSONObject();
		//jsonObject2.put("on", on_off);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}	

	//设置云台(ok)
	public static JSONObject SetPanTiltPosture(String ip, Float pan, Float tilt, Float zoom){
		String url = "http://" + ip + ":35182/beepatrol/ctrl_ptz";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("pan", pan);
		jsonObject2.put("tilt", tilt);
		jsonObject2.put("zoom", zoom);
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	}
	
	//存储可见光图像(ok)
	public static boolean getRGB(String ip, String path){
		String url = "http://" + ip + ":35182/beepatrol/shot_rgb";
        HttpGet get = new HttpGet(url);
		InputStream in = null;
		FileOutputStream fos = null;
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(20000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(20000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			fos = new FileOutputStream(path);
			HttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();		
			
			if(entity != null){
				in = entity.getContent();
				byte[] buffer = new byte[1024];
            	int bytesRead;
      			while ((bytesRead = in.read(buffer)) != -1) {
        			fos.write(buffer, 0, bytesRead);
      			}
			}
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				System.out.println("服务器异常");
			}
			
		} catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			//get.abort();
			if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println("关闭流异常");
				throw new RuntimeException(e);
			}
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
			fos.close();
			} catch (IOException e) {
				System.out.println("关闭流异常");
				throw new RuntimeException(e);
			}
      	}
	  }
		return true;
	}
	

	//存储可见光图像(ok)
	public static boolean GetMap(String ip, String path){
		String url = "http://" + ip + ":35181/beepatrol/map";
        HttpGet get = new HttpGet(url);
		InputStream in = null;
		FileOutputStream fos = null;
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(5000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(5000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			fos = new FileOutputStream(path);
			HttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();		
			
			if(entity != null){
				in = entity.getContent();
				byte[] buffer = new byte[1024];
            	int bytesRead;
      			while ((bytesRead = in.read(buffer)) != -1) {
        			fos.write(buffer, 0, bytesRead);
      			}
			}
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				System.out.println("服务器异常");
			}
			
		} catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			//get.abort();
			if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println("关闭流异常");
				throw new RuntimeException(e);
			}
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (fos != null) {
			try {
			fos.close();
			} catch (IOException e) {
				System.out.println("关闭流异常");
				throw new RuntimeException(e);
			}
      	}
	  }
		return true;
	}
	

	//获取可见光图像数据(ok)
	public static byte[] getRGBPicture(String ip, Boolean isNew){
		String url = "http://" + ip + ":35182/beepatrol/shot_rgb";
        HttpGet get = new HttpGet(url);
		InputStream in = null;
		ByteArrayOutputStream os = null;
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(5000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(5000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			HttpResponse response = httpClient.execute(get);
			os = new ByteArrayOutputStream();
            HttpEntity entity = response.getEntity();		

			if(entity != null){
				in = entity.getContent();

				BufferedImage buffImg = ImageIO.read(in);

				if(isNew)
				{
					double temp = getMaxtemp(ip);
					DecimalFormat decimalFormat = new DecimalFormat("#.00");
					String result = decimalFormat.format(temp);

					//得到画笔对象
					Graphics g = buffImg.getGraphics();
					//设置文字颜色。
					g.setColor(Color.RED);
					//最后一个参数用来设置字体的大小
					Font f = new Font("宋体",Font.PLAIN,20);
					g.setFont(f);
					//60,160 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
					g.drawString("最高温度：" + result ,buffImg.getWidth() - 200,20);
					g.dispose();


				}

				ImageIO.write(buffImg, "jpeg", os);
				// byte[] buffer = new byte[1024];
            	// int bytesRead;
      			// while ((bytesRead = in.read(buffer)) != -1) {
        		// 	os.write(buffer, 0, bytesRead);
      			// }
				
				return os.toByteArray();
			}
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				System.out.println("服务器异常");
			}
		} catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			//get.abort();
			if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println("关闭流异常");
				throw new RuntimeException(e);
			}
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (os != null) {
			try {
			os.close();
			} catch (IOException e) {
				System.out.println("关闭流异常");
				throw new RuntimeException(e);
			}
      	}
	  }
	  byte[] buffer = new byte[1024];
      return  buffer;
	}

	//在可见光图像上添加文字(ok)
	public static String addFont(String filePath,String word,String targetPath){
    try{
         File file = new File(filePath);
        if(!file.exists()){
            return "";
        }

        InputStream is = new FileInputStream(filePath);
        BufferedImage buffImg = ImageIO.read(is);

        //得到画笔对象
        Graphics g = buffImg.getGraphics();
        //设置文字颜色。
        g.setColor(Color.WHITE);
        //最后一个参数用来设置字体的大小
        Font f = new Font("微软雅黑",Font.PLAIN,120);
        g.setFont(f);
        //60,160 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
        g.drawString(word,60,160);
        g.dispose();
        OutputStream os;
        targetPath = targetPath + System.currentTimeMillis() + ".jpg";
        File file1 = new File(targetPath);
        if(!file1.exists()){
            file1.createNewFile();
        }

        os = new FileOutputStream(targetPath);
        ImageIO.write(buffImg, "jpg", os);

        is.close();
        os.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return targetPath;
    }


	//获取红外热像仪图像数据(ok)
	public static Map<String, Object> getheat(String ip){

		Map<String, Object> map = new HashMap<>();
		JSONObject temp = getTenAreaTempInPicture(ip);
		JSONArray result_max = (JSONArray)temp.get("maxtemp"); 
		JSONArray result_min = (JSONArray)temp.get("mintemp"); 
		JSONArray result_x = (JSONArray)temp.get("result_x"); 
		JSONArray result_y = (JSONArray)temp.get("result_y");
		
		String url = "http://" + ip + ":35182/beepatrol/shot_heatmap";
		ByteArrayOutputStream os = null;
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("data", 0);
		InputStream in = null;
		URI uri = null;
		
		try{
			uri = new URIBuilder(url)
					.setParameter("data", String.valueOf(0)).build();

		}
		catch(URISyntaxException e)
		{
			e.printStackTrace();
		}
		HttpGet get = new HttpGet(uri);
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(5000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(5000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		float maxTemp = 0;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			HttpResponse response = httpClient.execute(get);
			os = new ByteArrayOutputStream();
            HttpEntity entity = response.getEntity();		
			
			if(entity != null){
				in = entity.getContent();

				BufferedImage buffImg = ImageIO.read(in);
				Graphics g = buffImg.getGraphics();

				g.setColor(Color.GRAY);
				g.drawLine(213, 0, 213, 480);
				g.drawLine(426, 0, 426, 480);
				//g.drawLine(384, 0, 384, 480);
				//g.drawLine(512, 0, 512, 480);
				g.drawLine(0, 160, 640, 160);
				g.drawLine(0, 320, 640, 320);

				g.setColor(Color.RED);
				g.drawLine(213, 160, 426, 160);
				g.drawLine(213, 320, 426, 320);
				g.drawLine(213, 160, 213, 320);
				g.drawLine(426, 160, 426, 320);

				for(int i = 0;i < result_max.size(); i++)
				{
					double temp_max = (double)result_max.get(i);
					double temp_min = (double)result_min.get(i);

					int x_max = (int)result_x.get(i * 2);
					int y_max = (int)result_y.get(i * 2);
					int x_min = (int)result_x.get(i * 2 + 1);
					int y_min = (int)result_y.get(i * 2 + 1);

					
					g.setColor(Color.GREEN);
					g.drawRect(y_max - 10, x_max - 10, 20, 20);
					g.setFont(new Font("宋体", Font.BOLD, 20));
					g.drawString(String.valueOf(temp_max), y_max  - 10 , x_max  - 10 + 20);

					g.setColor(Color.YELLOW);
					g.drawRect(y_min -10, x_min - 10, 20, 20);
					g.setFont(new Font("宋体", Font.BOLD, 20));
					g.drawString(String.valueOf(temp_min), y_min -10 , x_min - 10 + 20);


				}
				g.dispose();
				ImageIO.write(buffImg, "jpeg", os);
				// byte[] buffer = new byte[1024];
            	// int bytesRead;
      			// while ((bytesRead = in.read(buffer)) != -1) {
        		// 	os.write(buffer, 0, bytesRead);
      			// }
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("maxtemp", result_max);
				jsonObject.put("mintemp", result_min);

				map.put("ByteArray",os.toByteArray());
				map.put("temp",jsonObject);
				return map;
			}

			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				System.out.println("服务器异常");
			}
		} catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			//get.abort();
			if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println("关闭流异常");
				throw new RuntimeException(e);
			}
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (os != null) {
			try {
			os.close();
			} catch (IOException e) {
				System.out.println("关闭流异常");
				throw new RuntimeException(e);
			}
      	}
	  }
      return  map;
	}

	
	//获取十个区域温度
	public static JSONObject getTenAreaTemp(String ip)
	{
		JSONObject jsonObject = new JSONObject();

		List<Float> result_max = new ArrayList<>(); 
		List<Float> result_min = new ArrayList<>(); 

		String url = "http://" + ip + ":35182/beepatrol/shot_heatmap";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("data", 1);
		InputStream in = null;
		URI uri = null;
		try{
			uri = new URIBuilder(url)
					.setParameter("data", String.valueOf(1)).build();
		}
		catch(URISyntaxException e)
		{
			e.printStackTrace();
		}
		HttpGet get = new HttpGet(uri);
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(5000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(5000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			String param = URLEncoder.encode(jsonObject2.toString(), "UTF-8");
			//get.setURI(URI.create(url + "?json=" + param));
			HttpResponse response = httpClient.execute(get);

			//result = getHttpEntityContent(response);
			
			HttpEntity entity = response.getEntity();		
			
			if(entity != null){
				in = entity.getContent();
				byte[] buffer = new byte[1024 * 1024];
            	int bytesRead = 0;
				int count = 0;
      			while ((count = in.read(buffer,bytesRead,1000)) != -1) {
					bytesRead += count;
        			continue;
					//break;
      			}
				short[] shortValue = new short[bytesRead / 2];
				for (int i = 0; i < shortValue.length; i++) {
					shortValue[i] = (short) ((buffer[i * 2] & 0xff) | ((buffer[i * 2 + 1] & 0xff)) << 8);
				}
				int width = Short.toUnsignedInt(shortValue[0]);
				int hight = Short.toUnsignedInt(shortValue[1]);
				float slope = Short.toUnsignedInt(shortValue[2]);
				float offset = Short.toUnsignedInt(shortValue[3]);

				short[][] pointValue = new short[hight][width];
				
				for(int n = 0; n < hight; n++)
				{
					for(int m = 0; m < width; m++)
					{
						pointValue[n][m] = shortValue[4 + n*width + m];
					}
				}

				for (int i = 0; i < hight; i += hight/3) {
					for (int j = 0; j < width - 1; j += width/3) {
						int subHeight = hight/3;
						int subWidth = width/3;
						short[][] subArr = new short[subHeight][subWidth];
						for (int k = 0; k < subHeight; k++) {
							for (int l = 0; l < subWidth; l++) {
								subArr[k][l] = pointValue[i+k][j+l];
							}
						}
						float maxValue = 0;
						float minValue = 65535;
						for (int k = 0; k < subHeight; k++) {
							for (int l = 0; l < subWidth; l++) {
								if (subArr[k][l] > maxValue) {
									maxValue = subArr[k][l];
								}
							}
						}

						for (int k = 0; k < subHeight; k++) {
							for (int l = 0; l < subWidth; l++) {
								if (subArr[k][l] < minValue) {
									minValue = subArr[k][l];
								}
							}
						}
						result_max.add(maxValue / (slope + offset));
						result_min.add(minValue / (slope + offset));

					}
				}
			}
			
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				String result = "服务器异常";
			}
			
		} catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//get.abort();
		}
		jsonObject.put("maxtemp", result_max);
		jsonObject.put("mintemp", result_min);
		return  jsonObject;
	}

	//获取十个区域温度，并返回每个区域中心点坐标
	public static JSONObject getTenAreaTempInPicture(String ip)
	{
		JSONObject jsonObject = new JSONObject();

		List<Float> result_max = new ArrayList<>(); 
		List<Float> result_min = new ArrayList<>(); 
		List<Integer> result_x = new ArrayList<>(); 
		List<Integer> result_y = new ArrayList<>();

		String url = "http://" + ip + ":35182/beepatrol/shot_heatmap";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("data", 1);
		InputStream in = null;
		URI uri = null;
		try{
			uri = new URIBuilder(url)
					.setParameter("data", String.valueOf(1)).build();
		}
		catch(URISyntaxException e)
		{
			e.printStackTrace();
		}
		HttpGet get = new HttpGet(uri);
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(5000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(5000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			String param = URLEncoder.encode(jsonObject2.toString(), "UTF-8");
			//get.setURI(URI.create(url + "?json=" + param));
			HttpResponse response = httpClient.execute(get);

			//result = getHttpEntityContent(response);
			
			HttpEntity entity = response.getEntity();		
			
			if(entity != null){
				in = entity.getContent();
				byte[] buffer = new byte[1024 * 1024];
            	int bytesRead = 0;
				int count = 0;
      			while ((count = in.read(buffer,bytesRead,1000)) != -1) {
					bytesRead += count;
        			continue;
					//break;
      			}
				short[] shortValue = new short[bytesRead / 2];
				for (int i = 0; i < shortValue.length; i++) {
					shortValue[i] = (short) ((buffer[i * 2] & 0xff) | ((buffer[i * 2 + 1] & 0xff)) << 8);
				}
				int width = Short.toUnsignedInt(shortValue[0]);
				int hight = Short.toUnsignedInt(shortValue[1]);
				float slope = Short.toUnsignedInt(shortValue[2]);
				float offset = Short.toUnsignedInt(shortValue[3]);

				short[][] pointValue = new short[hight][width];
				
				for(int n = 0; n < hight; n++)
				{
					for(int m = 0; m < width; m++)
					{
						pointValue[n][m] = shortValue[4 + n*width + m];
					}
				}

				for (int i = 0; i < hight; i += hight/3) {
					for (int j = 0; j < width - 1; j += width/3) {
						int subHeight = hight/3;
						int subWidth = width/3;
						short[][] subArr = new short[subHeight][subWidth];
						for (int k = 0; k < subHeight; k++) {
							for (int l = 0; l < subWidth; l++) {
								subArr[k][l] = pointValue[i+k][j+l];
							}
						}
						float maxValue = 0;
						float minValue = 65535;
						for (int k = 0; k < subHeight; k++) {
							for (int l = 0; l < subWidth; l++) {
								if (subArr[k][l] > maxValue) {
									maxValue = subArr[k][l];
								}
							}
						}
						List<Integer> x = new ArrayList<>();
						List<Integer> y = new ArrayList<>();
						int sum_x = 0;
						int sum_y = 0;
						int closest_max = 0;
						int closest_min = 0;
						int min_dis = 0;
						for (int k = 0; k < subHeight; k++) {
							for (int l = 0; l < subWidth; l++) {
								if (subArr[k][l] == maxValue) {
									x.add(k + i);
									y.add(j + l);
								}
							}
						}
						for (int num : x) {
							sum_x += num;
						}
						sum_x = sum_x / x.size();

						for (int num : y) {
							sum_y += num;
						}
						sum_y = sum_y / y.size();

						min_dis = Math.abs(x.get(0) - sum_x) + Math.abs(y.get(0) - sum_y);
						for(int m = 0; m < x.size(); m++)
						{
							if(Math.abs(x.get(m) - sum_x) + Math.abs(y.get(m) - sum_y) < min_dis)
							{
								min_dis = Math.abs(x.get(m) - sum_x) + Math.abs(y.get(m) - sum_y);
								closest_max = m;
							}
						}

						result_x.add(x.get(closest_max));
						result_y.add(y.get(closest_max));

						x.clear();
						y.clear();
						sum_x = 0;
						sum_y = 0;
						min_dis = 0;

						for (int k = 0; k < subHeight; k++) {
							for (int l = 0; l < subWidth; l++) {
								if (subArr[k][l] < minValue) {
									minValue = subArr[k][l];
								}
							}
						}

						for (int k = 0; k < subHeight; k++) {
							for (int l = 0; l < subWidth; l++) {
								if (subArr[k][l] == minValue) {
									x.add(k + i);
									y.add(j + l);
								}
							}
						}

						for (int num : x) {
							sum_x += num;
						}
						sum_x = sum_x / x.size();

						for (int num : y) {
							sum_y += num;
						}
						sum_y = sum_y / y.size();
						min_dis = Math.abs(x.get(0) - sum_x) + Math.abs(y.get(0) - sum_y);
						for(int m = 0; m < x.size(); m++)
						{
							if(Math.abs(x.get(m) - sum_x) + Math.abs(y.get(m) - sum_y) < min_dis)
							{
								min_dis = Math.abs(x.get(m) - sum_x) + Math.abs(y.get(m) - sum_y);
								closest_min = m;
							}
						}
						result_x.add(x.get(closest_min));
						result_y.add(y.get(closest_min));



						result_max.add(maxValue / (slope + offset));
						result_min.add(minValue / (slope + offset));

					}
				}
			}
			
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				String result = "服务器异常";
			}
			
		} catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//get.abort();
		}
		jsonObject.put("maxtemp", result_max);
		jsonObject.put("mintemp", result_min);
		jsonObject.put("result_x", result_x);
		jsonObject.put("result_y", result_y);
		
		return  jsonObject;
	}



	//获取红外热像仪面阵数据(ok)
	public static float getMaxtemp(String ip){
		String url = "http://" + ip + ":35182/beepatrol/shot_heatmap";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("data", 1);
		InputStream in = null;
		URI uri = null;
		
		try{
			uri = new URIBuilder(url)
					.setParameter("data", String.valueOf(1)).build();
		}
		catch(URISyntaxException e)
		{
			e.printStackTrace();
		}
		HttpGet get = new HttpGet(uri);
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(5000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(5000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		float maxTemp = 0;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			String param = URLEncoder.encode(jsonObject2.toString(), "UTF-8");
			//get.setURI(URI.create(url + "?json=" + param));
			HttpResponse response = httpClient.execute(get);

			//result = getHttpEntityContent(response);
			
			HttpEntity entity = response.getEntity();		
			
			if(entity != null){
				in = entity.getContent();
				byte[] buffer = new byte[1024 * 1024];
            	int bytesRead = 0;
				int count = 0;
      			while ((count = in.read(buffer,bytesRead,1000)) != -1) {
					bytesRead += count;
        			continue;
					//break;
      			}
				short[] shortValue = new short[bytesRead / 2];
				for (int i = 0; i < shortValue.length; i++) {
					shortValue[i] = (short) ((buffer[i * 2] & 0xff) | ((buffer[i * 2 + 1] & 0xff)) << 8);
				}
				int width = Short.toUnsignedInt(shortValue[0]);
				int hight = Short.toUnsignedInt(shortValue[1]);
				float slope = Short.toUnsignedInt(shortValue[2]);
				float offset = Short.toUnsignedInt(shortValue[3]);
				float max = 0;
				for(int i = 4; i < width * hight + 4; i++){
					if(max < shortValue[i])
					{
						max = shortValue[i];
					}
				}
				maxTemp =  max / (slope + offset);
			}
			
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				String result = "服务器异常";
			}
			
		} catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//get.abort();
		}
		return  maxTemp;
	}

	//分析可见光图片亮度(ok)
	public static double Analysis_V(String path)
	{
		String sourceDir = "";
		double avgBrightness =0;
		try {
			BufferedImage img = ImageIO.read(new File(path));

			// 计算平均亮度
			int totalBrightness = 0;
			for (int y = 0; y < img.getHeight(); y++) {
				for (int x = 0; x < img.getWidth(); x++) {
					int rgb = img.getRGB(x, y);
					int r = (rgb >> 16) & 0xFF;
					int g = (rgb >> 8) & 0xFF;
					int b = rgb & 0xFF;
					int brightness = (r + g + b) / 3;
					totalBrightness += brightness;
				}
			}
			avgBrightness = (double) totalBrightness / (img.getWidth() * img.getHeight());

			System.out.println("Average brightness: " + avgBrightness);
		} catch (Exception e) {
			// TODO: handle exception
		}
		

        // //Mat img = Imgcodecs.imread(path);

        // Mat imgHSV = new Mat(img.rows(), img.cols(), CvType.CV_8UC3);
        // //Mat img2 = new Mat(img.rows(), img.cols(), CvType.CV_8UC3);

        // //转成HSV空间
        // opencv_imgproc.cvtColor(img, imgHSV, opencv_imgproc.COLOR_BGR2HSV); 

        // int width = imgHSV.cols();
        // int height = imgHSV.rows();
        // int dims = imgHSV.channels();
        // byte[] data = new byte[width * height * dims];
        // imgHSV.data().get(data);

        // double count = 0;

        // int index;
        // double  v = 0, h;
        // for (int row = 0; row < height; row++) {
        //     for (int col = 0; col < width * dims; col += dims) {
        //         index = row * width * dims + col;
        //         h = (data[index] & 0xff);
        //         //s = (data[index + 1] & 0xff)  + s;
        //         //v = (data[index + 2] & 0xff) + v;
                
        //         if (count == 0)
        //         {
        //             v	 = (data[index + 2] & 0xff);
        //         }
        //         else
        //         {
        //             v = (v + (data[index + 2] & 0xff) / count) * count / (count + 1);
        //         }
        //         count++;
        //     }
        // }
        return avgBrightness;
	}
	//开始录制可见光视频流(ok)
	public static JSONObject start_video_record_rgb(String ip){
		String url = "http://" + ip + ":35182/beepatrol/start_video_record_rgb";
		JSONObject jsonObject2 = new JSONObject();
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	} 

	//结束录制可见光视频流(ok)
	public static JSONObject stop_video_record_rgb(String ip){
		String url = "http://" + ip + ":35182/beepatrol/stop_video_record_rgb";
		JSONObject jsonObject2 = new JSONObject();
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	} 

	//列出可下载的可见光视频(ok)
	public static JSONObject list_video_record_rgb(String ip, int id){
		String url = "http://" + ip + ":35182/beepatrol/list_video_record_rgb";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("id", id);
		JSONObject jsStr = null;
		String result = "";
		URI uri = null;
		
		try{
			uri = new URIBuilder(url)
					.setParameter("id", String.valueOf(id)).build();
		}
		catch(URISyntaxException e)
		{
			e.printStackTrace();
		}
		HttpGet get = new HttpGet(uri);
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(5000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(5000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			String param = URLEncoder.encode(jsonObject2.toString(), "UTF-8");
			//get.setURI(URI.create(url + "?json=" + param));
			HttpResponse response = httpClient.execute(get);	
			
			result = getHttpEntityContent(response);
    		jsStr = JSONObject.fromObject(result);
			
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				 result = "服务器异常";
			}
			
		} catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//get.abort();
		}
		return  jsStr;
	} 
	//下载一次任务的视频(ok)
	public static Boolean download_video_record_rgb_all(String ip, int id, String path)
	{
		JSONObject result = (JSONObject)list_video_record_rgb(ip, id).get("data");
		
		JSONArray filelist = result.getJSONArray("files");

		JSONArray creatTime = result.getJSONArray("dates");
		for( int i = 0; i < filelist.size(); i++)
		{
			
			download_video_record_rgb_one(ip,id,filelist.getString(i),path + "/" + creatTime.getString(i).replace(" ","_").replace(":", "_") + ".mp4");
		}
		return true;
	}

	//下载可见光视频(ok)
	public static Boolean download_video_record_rgb_one(String ip, int id, String filename,String path){
		String url = "http://" + ip + ":35182/beepatrol/download_video_record_rgb";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("id", id);
		jsonObject2.put("file", filename);
		String result = "";
		InputStream in = null;
		FileOutputStream fos = null;
		URI uri = null;
		
		try{
			uri = new URIBuilder(url)
					.setParameter("id", String.valueOf(id))
					.setParameter("file", filename).build();
		}
		catch(URISyntaxException e)
		{
			e.printStackTrace();
		}
		HttpGet get = new HttpGet(uri);
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(5000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(5000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			File outputFile = new File(path);
			if(outputFile.exists())
				outputFile.delete();
			outputFile.createNewFile();
			fos = new FileOutputStream(outputFile);
			String param = URLEncoder.encode(jsonObject2.toString(), "UTF-8");
			//get.setURI(URI.create(url + "?json=" + param));
			HttpResponse response = httpClient.execute(get);	
			
			HttpEntity entity = response.getEntity();		
			
			if(entity != null){
				in = entity.getContent();
				byte[] buffer = new byte[1024];
            	int bytesRead;
      			while ((bytesRead = in.read(buffer)) != -1) {
        			fos.write(buffer, 0, bytesRead);
      			}
			}
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				 result = "服务器异常";
				 return false;
			}
			
		} catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			try {
				fos.close();
			} catch (IOException e) {
				System.out.println("关闭流异常");
				throw new RuntimeException(e);
			}
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//get.abort();
		}
		return  true;
	} 

	//开始录制红外视频流(ok)
	public static JSONObject start_video_record_heat(String ip){
		String url = "http://" + ip + ":35182/beepatrol/start_video_record_thermal";
		JSONObject jsonObject2 = new JSONObject();
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	} 

	//结束录制红外视频流(ok)
	public static JSONObject stop_video_record_heat(String ip){
		String url = "http://" + ip + ":35182/beepatrol/stop_video_record_thermal";
		JSONObject jsonObject2 = new JSONObject();
		JSONObject result = Robot_API.post(jsonObject2, url);
		return result;
	} 

	//列出可下载的红外视频(ok)
	public static JSONObject list_video_record_heat(String ip, int id){
		String url = "http://" + ip + ":35182/beepatrol/list_video_record_thermal";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("id", id);
		JSONObject jsStr = null;
		String result = "";
		URI uri = null;
		
		try{
			uri = new URIBuilder(url)
					.setParameter("id", String.valueOf(id)).build();
		}
		catch(URISyntaxException e)
		{
			e.printStackTrace();
		}
		HttpGet get = new HttpGet(uri);
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(5000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(5000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			String param = URLEncoder.encode(jsonObject2.toString(), "UTF-8");
			//get.setURI(URI.create(url + "?json=" + param));
			HttpResponse response = httpClient.execute(get);	
			
			result = getHttpEntityContent(response);
    		jsStr = JSONObject.fromObject(result);
			
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				 result = "服务器异常";
			}
			
		} catch (Exception e){
			System.out.println("请求异常");
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//get.abort();
		}
		return  jsStr;
	} 
	//下载一次任务的红外视频(ok)
	public static Boolean download_video_record_heat_all(String ip, int id, String path)
	{
		JSONObject result = (JSONObject)list_video_record_heat(ip, id).get("data");
		
		JSONArray filelist = result.getJSONArray("files");

		JSONArray creatTime = result.getJSONArray("dates");
		for( int i = 0; i < filelist.size(); i++)
		{
			
			download_video_record_heat_one(ip,id,filelist.getString(i),path + "/" + creatTime.getString(i).replace(" ","_").replace(":", "_") + ".mp4");
		}
		return true;
	}
	//下载红外视频(ok)
	public static Boolean download_video_record_heat_one(String ip, int id, String filename,String path){
		String url = "http://" + ip + ":35182/beepatrol/download_video_record_thermal";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("id", id);
		jsonObject2.put("file", filename);
		String result = "";
		InputStream in = null;
		FileOutputStream fos = null;
		URI uri = null;
		
		try{
			uri = new URIBuilder(url)
					.setParameter("id", String.valueOf(id))
					.setParameter("file", filename).build();
		}
		catch(URISyntaxException e)
		{
			e.printStackTrace();
		}
		HttpGet get = new HttpGet(uri);
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(5000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(5000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			File outputFile = new File(path);
			if(outputFile.exists())
				outputFile.delete();
			outputFile.createNewFile();
			fos = new FileOutputStream(outputFile);
			String param = URLEncoder.encode(jsonObject2.toString(), "UTF-8");
			//get.setURI(URI.create(url + "?json=" + param));
			HttpResponse response = httpClient.execute(get);	
			
			HttpEntity entity = response.getEntity();		
			
			if(entity != null){
				in = entity.getContent();
				byte[] buffer = new byte[1024];
            	int bytesRead;
      			while ((bytesRead = in.read(buffer)) != -1) {
        			fos.write(buffer, 0, bytesRead);
      			}
			}
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				 result = "服务器异常";
				 return false;
			}
		} catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			try {
				fos.close();
			} catch (IOException e) {
				System.out.println("关闭流异常");
				throw new RuntimeException(e);
			}
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//get.abort();
		}
		return  true;
	}

    //获取地图信息(ok)
    public static byte[] getRobotMap(String ip){
        String url = "http://" + ip + ":35181/beepatrol/map";
        HttpGet get = new HttpGet(url);
		InputStream in = null;
		ByteArrayOutputStream os = null;
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(5000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(5000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		try{
			CloseableHttpClient httpClient = HttpClients.createDefault();
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			HttpResponse response = httpClient.execute(get);

            HttpEntity entity = response.getEntity();		
			
			if(entity != null){
				in = entity.getContent();
				byte[] buffer = new byte[1024];
            	int bytesRead;

				os = new ByteArrayOutputStream();
      			while ((bytesRead = in.read(buffer)) != -1) {
        			os.write(buffer, 0, bytesRead);
      			}
				return os.toByteArray();
			}
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				System.out.println("服务器异常");
			}
		} catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			//get.abort();
			if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println("关闭流异常");
			}
		}
		if (os != null) {
			try {
			os.close();
			} catch (IOException e) {
				System.out.println("关闭流异常");
			}
      	}
	  }
	  byte[] buffer = new byte[1024];
      return  buffer;
	}

	private static class StreamGobbler extends Thread {
			private InputStream inputStream;
	
			public StreamGobbler(InputStream inputStream) {
				this.inputStream = inputStream;
			}
	
			@Override
			public void run() {
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
					String line;
					while ((line = reader.readLine()) != null) {
						// 处理输出内容，可根据需要进行自定义
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	// 关闭ffmpeg进程
	public static void stopFFmpegProcess(Process process) {
		try {
			process.getOutputStream().write("q".getBytes());
			process.getOutputStream().flush();
			process.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		process.destroy();
	}

	//获取音频流
	public static void getAudio(String ip,String path, Boolean Flag_new)
	{	

		ByteArrayInputStream inputStream1 = null;
		FileOutputStream outStream = null;
		String url = "rtsp://" + ip + ":8554/video_stream_unicast";

		String url2 = "rtsp://" + ip + ":8554/audio";

		String outputFilePath = path  + "/out.aac";
		String outputFilePath2 = path  + "/out.wav";
		String outputFilePath3 = path  + "/out1.mp4";

		File file = new File(outputFilePath);
		if(file.exists())
		{
			file.delete();
		}	
	
		File file2 = new File(outputFilePath2);
		if(file2.exists())
		{
			file2.delete();
		}

		File file3 = new File(outputFilePath3);
		if(file3.exists())
		{
			file3.delete();
		}

		if(!Flag_new)
		{
			String[] ffmpegCommand = {
			"ffmpeg",
			"-i",
			url,
			"-t",
			"3", // 持续时间为3秒钟
			"-vcodec",
			"copy",
			outputFilePath3
			};

			try {
				// 执行FFmpeg命令行
				ProcessBuilder processBuilder = new ProcessBuilder(ffmpegCommand);
				processBuilder.redirectErrorStream(true); 
				Process process = processBuilder.start();

				// 异步读取子进程的输出流
				StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream());
				streamGobbler.start();


				
				// 等待命令行执行完成
				boolean exitCode = process.waitFor(15,TimeUnit.SECONDS);
				stopFFmpegProcess(process);
				// streamGobbler.join();
				
				if (exitCode) {
					System.out.println("音频流存储成功！");
				} else {
					System.out.println("音频流存储失败！");
				}
			}catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}

			
			String[] ffmpegCommand3 = {
				"ffmpeg",
				"-i",
				outputFilePath3,
				"-vn",
				"-acodec",
				"copy",
				outputFilePath
			};

			try {
				// 执行FFmpeg命令行
				ProcessBuilder processBuilder = new ProcessBuilder(ffmpegCommand3);
				Process process = processBuilder.start();

				// 异步读取子进程的输出流
				StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream());
				streamGobbler.start();

				// 等待命令行执行完成
				boolean exitCode = process.waitFor(15,TimeUnit.SECONDS);
				stopFFmpegProcess(process);
				// streamGobbler.join();

				if (exitCode) {
					System.out.println("音频流存储成功！");
				} else {
					System.out.println("音频流存储失败！");
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		else
		{
			String[] ffmpegCommand = {
				"ffmpeg",
				"-i",
				url2,
				"-t",
				"3", // 持续时间为3秒钟
				"-vn",
				"-acodec",
				"copy",
				outputFilePath
			};
	
			try {
				// 执行FFmpeg命令行
				ProcessBuilder processBuilder = new ProcessBuilder(ffmpegCommand);
				Process process = processBuilder.start();
	
				// 等待命令行执行完成
				int exitCode = process.waitFor();
				if (exitCode == 0) {
					System.out.println("音频流存储成功！");
				} else {
					System.out.println("音频流存储失败！");
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}	
		}
	

		String[] ffmpegCommand2 = {
			"ffmpeg",
			"-i",
			outputFilePath,
			"-acodec",
			"pcm_s16le",
			"-ar",
			"44100",
			"-ac",
			"2",
			outputFilePath2
		};

		try {
			// 执行FFmpeg命令行
			ProcessBuilder processBuilder = new ProcessBuilder(ffmpegCommand2);
			Process process = processBuilder.start();

			// 获取命令行输出
			InputStream inputStream = process.getInputStream();
			// BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			// String line;
			// while ((line = reader.readLine()) != null) {
			// 	System.out.println(line);
			// }

			// 等待命令行执行完成
			int exitCode = process.waitFor();
			if (exitCode == 0) {
				System.out.println("转换成功！");
			} else {
				System.out.println("转换失败！");
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

			//转换成Wav文件
			//Mp3ToWav.ToWave(path );
		return;
	}
	//删除文件内的内容
	public static void deleteFilesInFolder(String folderPath) {
		File folder = new File(folderPath);

        if (!folder.exists()) {
            return;
        }

        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFilesInFolder(file.getAbsolutePath()); // 递归删除子文件夹
                } else {
                    file.delete(); // 删除文件
                }
            }
        }

        folder.delete(); // 删除空文件夹
    }

	//创建文件路径
	public static void createFolder(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            boolean success = folder.mkdirs();
            if (success) {
                System.out.println("Folder created successfully.");
            } else {
                System.out.println("Failed to create folder.");
            }
        } else {
            System.out.println("Folder already exists.");
        }
    }

	//删除日常任务配置文件
	public static void deleteTaskSetttings(String ip, Long PlanID)
	{
		String sourceDir = "";

		//读取ini配置文件
		Ini ini = new Ini();
		try {
		
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream configStream = classLoader.getResourceAsStream("route_settings.ini"); 
			ini.load(configStream);
		} catch (Exception e) {
			System.out.println("配置文件无法访问");
			e.printStackTrace();
		}
		String system = ini.get("option", "system");
		if(system.equals("windows"))
		{
			sourceDir = ini.get("windows", "basedir");
		}
		else if(system.equals("linux"))
		{
			sourceDir = ini.get("linux", "basedir");
		}
		String filePath = sourceDir +String.valueOf(PlanID) + ip.replace(".", "_")+ "_settings.txt"; // 替换为实际的文件路径
		File fileroute = new File(filePath);
		if(fileroute.exists())
		{
			fileroute.delete();
		}
	}
	//获取指定路径图片数据
	public static byte[] getImageBytes(String imagePath) throws IOException {
        File file = new File(imagePath);
		if(!file.exists())
		{
			byte[] temp = new byte[1024];
			return temp;
		}
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        fis.close();
        bos.close();

        return bos.toByteArray();
    }
	//任务执行
	public static Boolean StartTask(TaskCallback callable, String ip, String ip2, Long PlanID, Long taskId, InitParam initParam, List<TaskParam> taskParams,int tasktype, Boolean isCircle, List<Integer> open_doors, List<Integer> route){
		int code = 0;
		String msg = "";
		Boolean hava_store = false;
		JSONObject result = new JSONObject();

		//颗粒物采样id;
		int id = 1;

		String sourceDir = "";

		Boolean Flag_new = true;

		if(ip.equals(ip2))
			Flag_new = true;
		else
			Flag_new = false;


		//读取ini配置文件
		Ini ini = new Ini();
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream configStream = classLoader.getResourceAsStream("route_settings.ini"); 
			ini.load(configStream);
			// File inif = new File("src/main/java/com/ccdc/robot/domain/route_settings.ini");
			// ini.load(inif);

		} catch (Exception e) {
			System.out.println("配置文件无法访问");
			e.printStackTrace();
		}
		String system = ini.get("option", "system");
		String port  = ini.get("option","port");
		String python_ip = ini.get("option", "ip");
		if(system.equals("windows"))
		{
			sourceDir = ini.get("windows", "basedir");
		}
		else if(system.equals("linux"))
		{
			sourceDir = ini.get("linux", "basedir");
		}
		if(!Flag_new)
		{
			//开补光灯
			//switch_fill_light(ip2,true);
			//开门
			start_opendoor(python_ip, port, ip);
		}


		
		String baseDir = sourceDir + ip.replace(".", "_");
		//读取日常任务配置文件
		String filePath = sourceDir +String.valueOf(PlanID) + ip.replace(".", "_")+ "_settings.txt"; // 替换为实际的文件路径
		List<DetectParam> detectParamlist = new ArrayList<>();
		if(tasktype == 1)
		{
			File fileroute = new File(filePath);
			try {
				if(!fileroute.exists()){
					fileroute.createNewFile();
					hava_store = false;
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

			try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
				if(values[0].equals("@"))
				{
					DetectParam detectParam = new DetectParam();
					List<Set_ItemParam> params = new ArrayList<>();
					if((line = br.readLine()) != null)
					{
						values = line.split(" ");
						detectParam.setLoacationID(Integer.parseInt(values[0])); //巡检点ID
						detectParam.setItemID(Integer.parseInt(values[1]));     //ItemID
					}
					while(((line = br.readLine()) != null))
					{
						
						values = line.split(" ");
						if(!values[0].equals("#"))
						{
							int j = 0;
							Set_ItemParam temp = new Set_ItemParam();
							temp.setCategory(Integer.parseInt(values[ j * 6 ]));
							temp.setX1(Double.parseDouble(values[j * 1 + 1] ));
							temp.setY1(Double.parseDouble(values[j * 1 + 2] ));
							temp.setX2(Double.parseDouble(values[j * 1 + 3] ));
							temp.setY2(Double.parseDouble(values[j * 1 + 4] ));
							temp.setColor(Integer.parseInt(values[j * 1 + 5] ));
							temp.setValue(Double.parseDouble(values[j * 1 +6]));
							temp.setValue2(Integer.parseInt(values[j * 1 +7]));
							temp.setSwitch_on_off(Integer.parseInt(values[j * 1 + 8]));
							params.add(temp);
							//detectParam.getParams().add(temp);
						}
						else
						{
							break;
						}
					}
					detectParam.setParams(params);
					detectParamlist.add(detectParam);
				}	
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		}
		
		if(detectParamlist.size() > 0)
			hava_store = true;
		// result = stop_video_record_rgb(ip);
		// stop_video_record_heat(ip);
		//开始录制
		Date Task_record_start_time = new Date();

		if(Flag_new)
		{
			start_video_record_rgb(ip2);
			start_video_record_heat(ip2);
		}


		//初始化机器人
		try {
			result = SetPanTiltPosture(ip2,initParam.getPan(),initParam.getTilt(),initParam.getZoom());

			if(initParam.getFliter() != null)
			{
				set_ctrl_lifter(ip, initParam.getFliter());
			}
			if((int)result.get("code") != 0){
				code = (int)result.get("code");
				msg = (String)result.get("msg");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//等待初始化完成
		try{
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}	

		//开始执行任务
		if(isCircle == true)
		{
			while(true)
			{
				for(int i = 0; i < taskParams.size(); i++)
				{
					List<Integer> ParticleCounter_result = new ArrayList<>();
					TaskParam currenTaskParam = taskParams.get(i);
	
					//处理巡检点
	
					//发送移动命令
					result = postMove(ip, currenTaskParam.getLocationId(), open_doors);
					// if((int)result.get("code") != 0){
	
					// 	code = (int)result.get("code");
					// 	msg = (String)result.get("msg");
					// }
					try{
						Thread.sleep(3000);
					}
					catch(Exception e)
					{
						throw new RuntimeException(e);
					}
					//等待移动完成
					while(true){
						result = (JSONObject)getRobotStatus(ip);
						JSONObject data = (JSONObject)result.get("data");
						String state = (String)data.get("state");
						if((int)result.get("code") != 0){
							code = (int)result.get("code");
							msg = (String)result.get("msg");
						}
						if((state.equals("StandingBy"))|| (state.equals("Charging")))
						{
							break;
						}
						else
						{
							try{
								Thread.sleep(1500);
							}
							catch(Exception e)
							{
								throw new RuntimeException(e);
							}
						}
					}
	
					if(Flag_new)
					{
						//先进行颗粒物采集
						ParticleCounterParam currretParticleCounterParam = currenTaskParam.getParticleCounter_Param();
	
						for(int p = 0; p < currretParticleCounterParam.getCollCycles(); p++)
						{
							//启动颗粒物采样
							enable_particle_counter(ip2,id,30,currretParticleCounterParam.getCollDuration());
	
							try{
								Thread.sleep(currretParticleCounterParam.getCollDuration() * 1000 + 30 * 1000);
							}
							catch(Exception e)
							{
								throw new RuntimeException(e);
							}
							//等待采样完成
							int count = 0;
							while(count < 30){
								result = (JSONObject)getPeripheralStatus(ip2);
								JSONObject data = (JSONObject)result.get("data");
								JSONObject ptcl_cnt = (JSONObject)data.get("ptcl_cnt");
								String sample_status = (String)ptcl_cnt.get("sample_status"); //采样状态
								int sample_id = (int)ptcl_cnt.get("id"); //采样id
								int device_status = (int)ptcl_cnt.get("device_status"); //设备状态
	
								if((sample_status.equals("Success"))  && (sample_id == id))
								{	
									ParticleCounter_result.add((int)ptcl_cnt.get(currretParticleCounterParam.getName()));
									break;
								}
								else
								{
									System.out.println(sample_status);
									if(sample_status.equals("Failed"))
									{
										break;
									}
									if(device_status != 0)
									{
										ParticleCounter_result.add(0);
										break;
									}
									try{
										Thread.sleep(1500);
									}
									catch(Exception e)
									{
										throw new RuntimeException(e);
									}
								}
								count++;
							}
							id++;
						}
					}
					System.out.println(ParticleCounter_result);
					//执行任务节点
					List<TaskItemParam> taskItemParams = currenTaskParam.getItemList();
					for(int j = 0; j < taskItemParams.size(); j++)
					{	
						TaskResult back_result = new TaskResult();
						try{
							//开始执行任务时间
							Date Task_StartTime = new Date(System.currentTimeMillis());
							
							TaskItemParam currenTaskItemParam = taskItemParams.get(j);
							
							long startTime = System.currentTimeMillis();
	
							//设置云盘
							try {
								SetPanTiltPosture(ip2,currenTaskItemParam.getPan(),currenTaskItemParam.getTilt(),currenTaskItemParam.getZoom());
								if(currenTaskItemParam.getLifter() != null)
								{
									set_ctrl_lifter(ip, currenTaskItemParam.getLifter());
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
	
							//等待云盘设置成功
							try{
								Thread.sleep(5000);
							}
							catch(Exception e)
							{
								throw new RuntimeException(e);
							}
							//开始录像时间
							Date Record_StartTime = new Date(System.currentTimeMillis());
	
							//System.getProperty("user.dir");
							createFolder(baseDir);
							//拍照
							Date date = new Date();
							deleteFilesInFolder(baseDir + "/image");
							createFolder(baseDir+ "/image");
							SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
							File targetDir = new File(baseDir+ "/image/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpg");
								if(!targetDir.exists()){
									targetDir.createNewFile();
								}
							String rgbpath = baseDir + "/image/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpg";
							if(currenTaskItemParam.getShotState())
							{
								getRGB(ip2,rgbpath);			

								deleteFilesInFolder(baseDir+ "/result");
								createFolder(baseDir+ "/result");
								//识别可见光图片
								JSONObject res = (JSONObject)postDetectlight(python_ip, rgbpath, baseDir+"/result", port);
								System.out.println(res);
							}
	
	
							//获取红外图像
							Map<String, Object> heat = new HashMap<>();
							if(Flag_new)
							{
								heat = getheat(ip2);
								back_result.setDetectResultHeat(heat);
								back_result.setIsDataCall(true);
								back_result.setTaskId(taskId);
								back_result.setPointId(currenTaskParam.getPointId());
								back_result.setItemId(currenTaskItemParam.getItemId());
								callable.call(back_result);
							}
							else
							{
								back_result.setDetectResultHeat(heat);
								back_result.setIsDataCall(true);
								back_result.setTaskId(taskId);
								back_result.setPointId(currenTaskParam.getPointId());
								back_result.setItemId(currenTaskItemParam.getItemId());
								callable.call(back_result);
							}
			
							// callpython(rgbpath, baseDir+"/result", sourceDir +"yolov5-v8.0/runs/train/exp26/weights/best.pt",sourceDir + "yolov5-v8.0/detect_light.py","");
							// callpython(baseDir+"/result/myexp/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpeg" , baseDir+"/result", sourceDir+"yolov5-v8.0/runs/train/exp28/weights/best.pt", sourceDir + "yolov5-v8.0/detect_switch.py","");
							// //callpython(baseDir+"/result/myexp2/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpeg", baseDir+"/result", sourceDir +"yolov5-v8.0/runs/train/exp21/weights/best.pt", sourceDir + "yolov5-v8.0/detect_pointer.py","");
							// callpython(baseDir+"/result/myexp2/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpeg", baseDir+"/result", sourceDir +"yolov5-v8.0/runs/train/exp25/weights/best.pt", sourceDir + "yolov5-v8.0/detect_num_pointer(2).py",sourceDir + "yolov5-v8.0/runs/train/exp20/weights/best.pt");
							
							//python D:/Source/yolov5-v8.0/detect.py "D:/Source/yolov5-v8.0/runs/train/exp26/weights/best.pt" "D:/Source/yolov5-v8.0/runs/train/exp28/weights/best.pt" "D:/Source/yolov5-v8.0/runs/train/exp25/weights/best.pt" "D:/Source/yolov5-v8.0/runs/train/exp20/weights/best.pt" 
	
							String resultpath1 = baseDir+"/result/myexp/labels/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".txt";
							String resultpath2 = baseDir+"/result/myexp2/labels/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".txt";
							String resultpath3 = baseDir+"/result/myexp3/num_labels/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".txt";
							String resultpath4 = baseDir+"/result/myexp3/pointer_labels/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".txt";
	
							File fileroute1 = new File(resultpath1);
							if(!fileroute1.exists()){
								fileroute1.createNewFile();
							}
	
							File fileroute2 = new File(resultpath2);
							if(!fileroute2.exists()){
								fileroute2.createNewFile();
							}
	
							File fileroute3 = new File(resultpath3);
							if(!fileroute3.exists()){
								fileroute3.createNewFile();
							}
							
							File fileroute4= new File(resultpath4);
							if(!fileroute4.exists()){
								fileroute4.createNewFile();
							}
	
	
							//读取检测结果(指示灯:类别0)
							List<Set_ItemParam> light_param = new ArrayList<>();
							try (BufferedReader br = new BufferedReader(new FileReader(resultpath1))) {
								String line;
								while ((line = br.readLine()) != null) {
									String[] values = line.split(" ");
									Set_ItemParam temp = new Set_ItemParam();
									temp.setCategory(Integer.parseInt("0"));
									temp.setX1(Double.parseDouble(values[1]) - Double.parseDouble(values[3]) / 2);
									temp.setY1(Double.parseDouble(values[2]) - Double.parseDouble(values[4]) / 2);
									temp.setX2(Double.parseDouble(values[1]) + Double.parseDouble(values[3]) / 2);
									temp.setY2(Double.parseDouble(values[2]) + Double.parseDouble(values[4]) / 2);
									temp.setColor(Integer.parseInt(values[0]));
									temp.setValue(Double.parseDouble("0"));
									temp.setValue2(Integer.parseInt("0"));
									temp.setSwitch_on_off(Integer.parseInt("0"));
									light_param.add(temp);
								}
							}catch (IOException e) {
								e.printStackTrace();
							}
							//读取检测结果(开关:类别1)
							try (BufferedReader br = new BufferedReader(new FileReader(resultpath2))) {
								String line;
								while ((line = br.readLine()) != null) {
									String[] values = line.split(" ");
									Set_ItemParam temp = new Set_ItemParam();
									temp.setCategory(Integer.parseInt("1"));
									temp.setX1(Double.parseDouble(values[1]) - Double.parseDouble(values[3]) / 2);
									temp.setY1(Double.parseDouble(values[2]) - Double.parseDouble(values[4]) / 2);
									temp.setX2(Double.parseDouble(values[1]) + Double.parseDouble(values[3]) / 2);
									temp.setY2(Double.parseDouble(values[2]) + Double.parseDouble(values[4]) / 2);
									temp.setColor(Integer.parseInt("0"));
									temp.setValue(Double.parseDouble("0"));
									temp.setValue2(Integer.parseInt("0"));
									temp.setSwitch_on_off(Integer.parseInt(values[0]));
									light_param.add(temp);
								}
							}catch (IOException e) {
								e.printStackTrace();
							}
	
							//读取检测结果(指针:类别3)
							try (BufferedReader br = new BufferedReader(new FileReader(resultpath3))) {
								String line;
								while ((line = br.readLine()) != null) {
									String[] values = line.split(" ");
									Set_ItemParam temp = new Set_ItemParam();
									temp.setCategory(Integer.parseInt("2"));
									temp.setX1(Double.parseDouble(values[2]) - Double.parseDouble(values[4]) / 2);
									temp.setY1(Double.parseDouble(values[3]) - Double.parseDouble(values[5]) / 2);
									temp.setX2(Double.parseDouble(values[2]) + Double.parseDouble(values[4]) / 2);
									temp.setY2(Double.parseDouble(values[3]) + Double.parseDouble(values[5]) / 2);
									temp.setColor(Integer.parseInt("0"));
									temp.setValue(Double.parseDouble(values[0]));
									temp.setValue2(Integer.parseInt("0"));
									temp.setSwitch_on_off(Integer.parseInt("0"));
									light_param.add(temp);
								}
							}catch (IOException e) {
								e.printStackTrace();
							}
	
							//读取检测结果(数值:类别4)
							try (BufferedReader br = new BufferedReader(new FileReader(resultpath4))) {
								String line;
								while ((line = br.readLine()) != null) {
									String[] values = line.split(" ");
									Set_ItemParam temp = new Set_ItemParam();
									temp.setCategory(Integer.parseInt("3"));
									temp.setX1(Double.parseDouble(values[1]) - Double.parseDouble(values[3]) / 2);
									temp.setY1(Double.parseDouble(values[2]) - Double.parseDouble(values[4]) / 2);
									temp.setX2(Double.parseDouble(values[1]) + Double.parseDouble(values[3]) / 2);
									temp.setY2(Double.parseDouble(values[2]) + Double.parseDouble(values[4]) / 2);
									temp.setColor(0);
									temp.setValue(Double.parseDouble("0"));
									temp.setValue2(Integer.parseInt(values[0]));
									temp.setSwitch_on_off(Integer.parseInt("0"));
									light_param.add(temp);
								}
							}catch (IOException e) {
								e.printStackTrace();
							}
	
							//TODO 检测当前检测结果有没有存过，没有存过就进行存储
							if(!hava_store)
							{
								String data = "@\n";
								data = data + String.valueOf(currenTaskParam.getLocationId()) + " " + String.valueOf(j) + "\n";
								for(int m = 0; m < light_param.size(); m++)
								{
									String str = String.valueOf(light_param.get(m).getCategory()) + " " + String.valueOf(light_param.get(m).getX1()) + " " + 
									String.valueOf(light_param.get(m).getY1()) + " " + String.valueOf(light_param.get(m).getX2()) + " " + String.valueOf(light_param.get(m).getY2()) + " " +
									String.valueOf(light_param.get(m).getColor()) + " " + String.valueOf(light_param.get(m).getValue())  + " " + String.valueOf(light_param.get(m).getValue2())  + " " + String.valueOf(light_param.get(m).getSwitch_on_off());
									data = data + str + "\n";
								}
								data = data + "#" + "\n";
								//将检测结果存入txt中
								try {
									FileWriter writer = new FileWriter(filePath, true); // 第二个参数为true表示追加写入
									writer.write(data); // 写入数据并换行
									writer.close();
									System.out.println("数据已成功写入文件。");
								} catch (IOException e) {
									System.out.println("写入文件时出现错误：" + e.getMessage());
								}
							//有记录过
							}else{
								for(int k = 0; k < detectParamlist.size(); k++)
								{
									if(detectParamlist.get(k).getLoacationID() == currenTaskParam.getLocationId() && detectParamlist.get(k).getItemID() == j)
									{
										//比对结果是否正确
										for(int n = 0; n < light_param.size(); n++)
										{
											if(detectParamlist.get(k).getParams().size() != light_param.size())
											{
												code = 5;      
												msg = "识别过程出错，检测结果异常";
												break;
											}
											Set_ItemParam temp = detectParamlist.get(k).getParams().get(n);
											//计算重叠度
											double res1 = calculateOverlapRatio(light_param.get(n).getX1(),light_param.get(n).getY1(),light_param.get(n).getX2(),light_param.get(n).getY2(),
											temp.getX1(),temp.getY1(),temp.getX2(),temp.getY2());
											//比较类别
											if(res1 > 0.8)
											{
												if(light_param.get(n).getCategory() == temp.getCategory())
												{
													if(temp.getCategory() == 0) //灯
													{
														if(!(temp.getColor() == light_param.get(n).getColor()))
														{
															if(code == 0)
															{
																code = 1;      //灯错误
																msg = "机器指示灯异常";
															}	
															System.out.println("错误");
														}
														else
														{
															System.out.println("正常");
														}
													}
													else if(temp.getCategory() == 1) //开关
													{
														if(!(temp.getSwitch_on_off() == light_param.get(n).getSwitch_on_off()))
														{
															if(code == 0)
															{
																code = 2;      //开关错误
																msg = "机器开关分合异常";
															}	
															System.out.println("错误");
														}
														else
														{
															System.out.println("正常");
														}
													}
													else if(temp.getCategory() == 2) //指针
													{
														if(light_param.get(n).getValue() != 0)
														{
															if(Math.abs(temp.getValue() - light_param.get(n).getValue()) > 10)   //设置阈值
															{
																if(code == 0)
																{
																	code = 3;      //指针
																	msg = "机器仪表指示异常";
																}
																	
																System.out.println("错误");
															}
															else
															{
																System.out.println("正常");
															}
														}
													}
													else if(temp.getCategory() == 3) //数值
													{
														// if(!(temp.getValue2() / 10 == light_param.get(n).getValue2() / 10))
														// {
														// 	if(code == 0)
														// 	{
														// 		code = 4;      //数值
														// 		msg = "机器数值异常";
														// 	}
														// 	System.out.println("错误");
														// }
														// else
														// {
														// 	System.out.println("正常");
														// }
													}
												}
											}
										}
									}
								}
							}
	
							
							//HSV分析
							double v = Analysis_V(rgbpath);
					
							createFolder(baseDir+ "/audio");
							List<Double[]> wave = null;
							List<Double[]> fre = null;
							double maxTemp = 0;
								//获取音频 
							getAudio(ip2, baseDir + "/audio",Flag_new);
	
							//获取波形数据
							wave = WavDraw.ShowWave(baseDir+ "/audio");
	
							//获取频域数据
							fre = FFTCalc0ToEnd.ShowFre(baseDir+ "/audio");
	
							//红外分析
							if(Flag_new)
							{
								maxTemp = getMaxtemp(ip2);
							}		
	
							long endTime = System.currentTimeMillis();
							// 计算执行时间
							long executionTime = endTime - startTime;
	
							//摄像时间
							try{
								if(currenTaskItemParam.getRecordingTime() * 1000 - executionTime > 0)
									Thread.sleep(Math.abs(currenTaskItemParam.getRecordingTime() * 1000 - executionTime));
							}
							catch(Exception e)
							{
								throw new RuntimeException(e);
							}
	
							//停止录像时间
							Date Record_StopTime = new Date(System.currentTimeMillis());
	
							try{
								if(currenTaskItemParam.getResidenceTime() -currenTaskItemParam.getRecordingTime() > 0)
									Thread.sleep((Math.abs(currenTaskItemParam.getResidenceTime() -currenTaskItemParam.getRecordingTime())) * 1000);
							}
							catch(Exception e)
							{
								throw new RuntimeException(e);
							}
							//任务结束时间
							Date Task_StopTime = new Date(System.currentTimeMillis());
							back_result.setTaskId(taskId);
							back_result.setPointId(currenTaskParam.getPointId());
							back_result.setItemId(currenTaskItemParam.getItemId());
							back_result.setTaskStartTime(Task_StartTime);
							back_result.setTaskEndTime(Task_StopTime);
							back_result.setRecordStartTime(Record_StartTime);
							back_result.setRecordEndTime(Record_StopTime);
							back_result.setCode(code);
							back_result.setMsg(msg);
							back_result.setMaxTemp(maxTemp);
							back_result.setHSV_v(v);
							back_result.setFre(fre);
							back_result.setWave(wave);
							back_result.setParticleCounter_result(ParticleCounter_result);
							String resultpicture = baseDir+"/result/myexp3/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpg";
							back_result.setDetectResultRGB(getImageBytes(resultpicture));
							back_result.setDetectResultHeat(heat);
							//更新回调
							if(i == taskParams.size() -1 && j == taskItemParams.size() - 1){
								back_result.setIsOver(false);
								//停止录制
								Date Task_record_stop_time = new Date();
								if(Flag_new)
								{
									result = (JSONObject)stop_video_record_rgb(ip2).get("data");
									JSONObject result2 = (JSONObject)stop_video_record_heat(ip2).get("data");
									
									//可见光视频集的编号
									int rgb_record_id = (int)result.get("id");
	
									int heat_record_id = (int)result2.get("id");
	
									back_result.setRgb_download_id(rgb_record_id);
									back_result.setHeat_download_id(heat_record_id);
								}
								
								result = SetPanTiltPosture(ip2,initParam.getPan(),initParam.getTilt(),initParam.getZoom());
								if(initParam.getFliter() != null)
								{
									set_ctrl_lifter(ip, initParam.getFliter());
								}
								if(!Flag_new)
								{
									//关闭补光灯
									//switch_fill_light(ip2,false);
								}
	
								//任务执行完成
								back_result.setIsDataCall(false);
								callable.call(back_result);
								//重置参数
								code = 0;
								msg = "";
								
								// for(int s = route.size() - 1; s >= 0; s--)
								// {
								// 	//发送移动命令
								// 	result = postMove(ip, route.get(s), open_doors);
	
								// 	try{
								// 		Thread.sleep(3000);
								// 	}
								// 	catch(Exception e)
								// 	{
								// 		throw new RuntimeException(e);
								// 	}
								// 	//等待移动完成
								// 	while(true){
								// 		result = (JSONObject)getRobotStatus(ip);
								// 		JSONObject data = (JSONObject)result.get("data");
								// 		String state = (String)data.get("state");
								// 		if((int)result.get("code") != 0){
								// 			code = (int)result.get("code");
								// 			msg = (String)result.get("msg");
								// 		}
								// 		if((state.equals("StandingBy"))|| (state.equals("Charging")))
								// 		{
								// 			break;
								// 		}
								// 		else
								// 		{
								// 			try{
								// 				Thread.sleep(1500);
								// 			}
								// 			catch(Exception e)
								// 			{
								// 				throw new RuntimeException(e);
								// 			}
								// 		}
								// 	}
								// }
								// result = postMove(ip, -1, open_doors);
	
								// while(true){
								// 	result = (JSONObject)getRobotStatus(ip);
								// 	JSONObject data = (JSONObject)result.get("data");
								// 	String state = (String)data.get("state");
								// 	if((int)result.get("code") != 0){
								// 		code = (int)result.get("code");
								// 		msg = (String)result.get("msg");
								// 	}
								// 	if((state.equals("Charging")))
								// 	{
								// 		break;
								// 	}
								// 	else
								// 	{
								// 		try{
								// 			Thread.sleep(1500);
								// 		}
								// 		catch(Exception e)
								// 		{
								// 			throw new RuntimeException(e);
								// 		}
								// 	}
								// }
								// if(!Flag_new)
								// 	//关门
								// 	stop_opendoor(python_ip, port);
							}
							else{
								back_result.setIsOver(false);
								back_result.setIsDataCall(false);
								callable.call(back_result);
								//重置参数
								code = 0;
								msg = "";
							}
	
						}
						catch(Exception e){
							throw new RuntimeException(e);
						}
					
					}
				}
			}
			
		}
		else
		{
			for(int i = 0; i < taskParams.size(); i++)
			{
				List<Integer> ParticleCounter_result = new ArrayList<>();
				TaskParam currenTaskParam = taskParams.get(i);

				//处理巡检点

				//发送移动命令
				result = postMove(ip, currenTaskParam.getLocationId(), open_doors);
				// if((int)result.get("code") != 0){

				// 	code = (int)result.get("code");
				// 	msg = (String)result.get("msg");
				// }
				try{
					Thread.sleep(3000);
				}
				catch(Exception e)
				{
					throw new RuntimeException(e);
				}
				//等待移动完成
				while(true){
					result = (JSONObject)getRobotStatus(ip);
					JSONObject data = (JSONObject)result.get("data");
					String state = (String)data.get("state");
					if((int)result.get("code") != 0){
						code = (int)result.get("code");
						msg = (String)result.get("msg");
					}
					if((state.equals("StandingBy"))|| (state.equals("Charging")))
					{
						break;
					}
					else
					{
						try{
							Thread.sleep(1500);
						}
						catch(Exception e)
						{
							throw new RuntimeException(e);
						}
					}
				}

				if(Flag_new)
				{
					//先进行颗粒物采集
					ParticleCounterParam currretParticleCounterParam = currenTaskParam.getParticleCounter_Param();

					for(int p = 0; p < currretParticleCounterParam.getCollCycles(); p++)
					{
						//启动颗粒物采样
						enable_particle_counter(ip2,id,30,currretParticleCounterParam.getCollDuration());

						try{
							Thread.sleep(currretParticleCounterParam.getCollDuration() * 1000 + 30 * 1000);
						}
						catch(Exception e)
						{
							throw new RuntimeException(e);
						}
						//等待采样完成
						int count = 0;
						while(count < 30){
							result = (JSONObject)getPeripheralStatus(ip2);
							JSONObject data = (JSONObject)result.get("data");
							JSONObject ptcl_cnt = (JSONObject)data.get("ptcl_cnt");
							String sample_status = (String)ptcl_cnt.get("sample_status"); //采样状态
							int sample_id = (int)ptcl_cnt.get("id"); //采样id
							int device_status = (int)ptcl_cnt.get("device_status"); //设备状态

							if((sample_status.equals("Success"))  && (sample_id == id))
							{	
								ParticleCounter_result.add((int)ptcl_cnt.get(currretParticleCounterParam.getName()));
								break;
							}
							else
							{
								System.out.println(sample_status);
								if(sample_status.equals("Failed"))
								{
									break;
								}
								if(device_status != 0)
								{
									ParticleCounter_result.add(0);
									break;
								}
								try{
									Thread.sleep(1500);
								}
								catch(Exception e)
								{
									throw new RuntimeException(e);
								}
							}
							count++;
						}
						id++;
					}
				}
				System.out.println(ParticleCounter_result);
				//执行任务节点
				List<TaskItemParam> taskItemParams = currenTaskParam.getItemList();
				for(int j = 0; j < taskItemParams.size(); j++)
				{	
					TaskResult back_result = new TaskResult();
					try{
						//开始执行任务时间
						Date Task_StartTime = new Date(System.currentTimeMillis());
						
						TaskItemParam currenTaskItemParam = taskItemParams.get(j);
						
						long startTime = System.currentTimeMillis();

						//设置云盘
						try {
							SetPanTiltPosture(ip2,currenTaskItemParam.getPan(),currenTaskItemParam.getTilt(),currenTaskItemParam.getZoom());
							if(currenTaskItemParam.getLifter() != null)
							{
								set_ctrl_lifter(ip, currenTaskItemParam.getLifter());
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						

						//等待云盘设置成功
						try{
							Thread.sleep(5000);
						}
						catch(Exception e)
						{
							throw new RuntimeException(e);
						}
						//开始录像时间
						Date Record_StartTime = new Date(System.currentTimeMillis());

						//System.getProperty("user.dir");
						createFolder(baseDir);
						//拍照
						Date date = new Date();
						deleteFilesInFolder(baseDir + "/image");
						createFolder(baseDir+ "/image");
						SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
						File targetDir = new File(baseDir+ "/image/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpg");
							if(!targetDir.exists()){
								targetDir.createNewFile();
							}
						String rgbpath = baseDir + "/image/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpg";
						if(currenTaskItemParam.getShotState())
						{
							getRGB(ip2,rgbpath);			

							deleteFilesInFolder(baseDir+ "/result");
							createFolder(baseDir+ "/result");
							//识别可见光图片
							JSONObject res = (JSONObject)postDetectlight(python_ip, rgbpath, baseDir+"/result", port);
							System.out.println(res);
						}

						//获取红外图像
						Map<String, Object> heat = new HashMap<>();
						if(Flag_new)
						{
							heat = getheat(ip2);
							back_result.setDetectResultHeat(heat);
							back_result.setIsDataCall(true);
							back_result.setTaskId(taskId);
							back_result.setPointId(currenTaskParam.getPointId());
							back_result.setItemId(currenTaskItemParam.getItemId());
							callable.call(back_result);
						}
						else
						{
							back_result.setDetectResultHeat(heat);
							back_result.setIsDataCall(true);
							back_result.setTaskId(taskId);
							back_result.setPointId(currenTaskParam.getPointId());
							back_result.setItemId(currenTaskItemParam.getItemId());
							callable.call(back_result);
						}
						// callpython(rgbpath, baseDir+"/result", sourceDir +"yolov5-v8.0/runs/train/exp26/weights/best.pt",sourceDir + "yolov5-v8.0/detect_light.py","");
						// callpython(baseDir+"/result/myexp/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpeg" , baseDir+"/result", sourceDir+"yolov5-v8.0/runs/train/exp28/weights/best.pt", sourceDir + "yolov5-v8.0/detect_switch.py","");
						// //callpython(baseDir+"/result/myexp2/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpeg", baseDir+"/result", sourceDir +"yolov5-v8.0/runs/train/exp21/weights/best.pt", sourceDir + "yolov5-v8.0/detect_pointer.py","");
						// callpython(baseDir+"/result/myexp2/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpeg", baseDir+"/result", sourceDir +"yolov5-v8.0/runs/train/exp25/weights/best.pt", sourceDir + "yolov5-v8.0/detect_num_pointer(2).py",sourceDir + "yolov5-v8.0/runs/train/exp20/weights/best.pt");
						
						//python D:/Source/yolov5-v8.0/detect.py "D:/Source/yolov5-v8.0/runs/train/exp26/weights/best.pt" "D:/Source/yolov5-v8.0/runs/train/exp28/weights/best.pt" "D:/Source/yolov5-v8.0/runs/train/exp25/weights/best.pt" "D:/Source/yolov5-v8.0/runs/train/exp20/weights/best.pt" 

						String resultpath1 = baseDir+"/result/myexp/labels/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".txt";
						String resultpath2 = baseDir+"/result/myexp2/labels/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".txt";
						String resultpath3 = baseDir+"/result/myexp3/num_labels/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".txt";
						String resultpath4 = baseDir+"/result/myexp3/pointer_labels/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".txt";

						File fileroute1 = new File(resultpath1);
						if(!fileroute1.exists()){
							fileroute1.createNewFile();
						}

						File fileroute2 = new File(resultpath2);
						if(!fileroute2.exists()){
							fileroute2.createNewFile();
						}

						File fileroute3 = new File(resultpath3);
						if(!fileroute3.exists()){
							fileroute3.createNewFile();
						}
						
						File fileroute4= new File(resultpath4);
						if(!fileroute4.exists()){
							fileroute4.createNewFile();
						}


						//读取检测结果(指示灯:类别0)
						List<Set_ItemParam> light_param = new ArrayList<>();
						try (BufferedReader br = new BufferedReader(new FileReader(resultpath1))) {
							String line;
							while ((line = br.readLine()) != null) {
								String[] values = line.split(" ");
								Set_ItemParam temp = new Set_ItemParam();
								temp.setCategory(Integer.parseInt("0"));
								temp.setX1(Double.parseDouble(values[1]) - Double.parseDouble(values[3]) / 2);
								temp.setY1(Double.parseDouble(values[2]) - Double.parseDouble(values[4]) / 2);
								temp.setX2(Double.parseDouble(values[1]) + Double.parseDouble(values[3]) / 2);
								temp.setY2(Double.parseDouble(values[2]) + Double.parseDouble(values[4]) / 2);
								temp.setColor(Integer.parseInt(values[0]));
								temp.setValue(Double.parseDouble("0"));
								temp.setValue2(Integer.parseInt("0"));
								temp.setSwitch_on_off(Integer.parseInt("0"));
								light_param.add(temp);
							}
						}catch (IOException e) {
							e.printStackTrace();
						}
						//读取检测结果(开关:类别1)
						try (BufferedReader br = new BufferedReader(new FileReader(resultpath2))) {
							String line;
							while ((line = br.readLine()) != null) {
								String[] values = line.split(" ");
								Set_ItemParam temp = new Set_ItemParam();
								temp.setCategory(Integer.parseInt("1"));
								temp.setX1(Double.parseDouble(values[1]) - Double.parseDouble(values[3]) / 2);
								temp.setY1(Double.parseDouble(values[2]) - Double.parseDouble(values[4]) / 2);
								temp.setX2(Double.parseDouble(values[1]) + Double.parseDouble(values[3]) / 2);
								temp.setY2(Double.parseDouble(values[2]) + Double.parseDouble(values[4]) / 2);
								temp.setColor(Integer.parseInt("0"));
								temp.setValue(Double.parseDouble("0"));
								temp.setValue2(Integer.parseInt("0"));
								temp.setSwitch_on_off(Integer.parseInt(values[0]));
								light_param.add(temp);
							}
						}catch (IOException e) {
							e.printStackTrace();
						}

						//读取检测结果(指针:类别3)
						try (BufferedReader br = new BufferedReader(new FileReader(resultpath3))) {
							String line;
							while ((line = br.readLine()) != null) {
								String[] values = line.split(" ");
								Set_ItemParam temp = new Set_ItemParam();
								temp.setCategory(Integer.parseInt("2"));
								temp.setX1(Double.parseDouble(values[2]) - Double.parseDouble(values[4]) / 2);
								temp.setY1(Double.parseDouble(values[3]) - Double.parseDouble(values[5]) / 2);
								temp.setX2(Double.parseDouble(values[2]) + Double.parseDouble(values[4]) / 2);
								temp.setY2(Double.parseDouble(values[3]) + Double.parseDouble(values[5]) / 2);
								temp.setColor(Integer.parseInt("0"));
								temp.setValue(Double.parseDouble(values[0]));
								temp.setValue2(Integer.parseInt("0"));
								temp.setSwitch_on_off(Integer.parseInt("0"));
								light_param.add(temp);
							}
						}catch (IOException e) {
							e.printStackTrace();
						}

						//读取检测结果(数值:类别4)
						try (BufferedReader br = new BufferedReader(new FileReader(resultpath4))) {
							String line;
							while ((line = br.readLine()) != null) {
								String[] values = line.split(" ");
								Set_ItemParam temp = new Set_ItemParam();
								temp.setCategory(Integer.parseInt("3"));
								temp.setX1(Double.parseDouble(values[1]) - Double.parseDouble(values[3]) / 2);
								temp.setY1(Double.parseDouble(values[2]) - Double.parseDouble(values[4]) / 2);
								temp.setX2(Double.parseDouble(values[1]) + Double.parseDouble(values[3]) / 2);
								temp.setY2(Double.parseDouble(values[2]) + Double.parseDouble(values[4]) / 2);
								temp.setColor(0);
								temp.setValue(Double.parseDouble("0"));
								temp.setValue2(Integer.parseInt(values[0]));
								temp.setSwitch_on_off(Integer.parseInt("0"));
								light_param.add(temp);
							}
						}catch (IOException e) {
							e.printStackTrace();
						}

						//TODO 检测当前检测结果有没有存过，没有存过就进行存储
						if(!hava_store)
						{
							String data = "@\n";
							data = data + String.valueOf(currenTaskParam.getLocationId()) + " " + String.valueOf(j) + "\n";
							for(int m = 0; m < light_param.size(); m++)
							{
								String str = String.valueOf(light_param.get(m).getCategory()) + " " + String.valueOf(light_param.get(m).getX1()) + " " + 
								String.valueOf(light_param.get(m).getY1()) + " " + String.valueOf(light_param.get(m).getX2()) + " " + String.valueOf(light_param.get(m).getY2()) + " " +
								String.valueOf(light_param.get(m).getColor()) + " " + String.valueOf(light_param.get(m).getValue())  + " " + String.valueOf(light_param.get(m).getValue2())  + " " + String.valueOf(light_param.get(m).getSwitch_on_off());
								data = data + str + "\n";
							}
							data = data + "#" + "\n";
							//将检测结果存入txt中
							try {
								FileWriter writer = new FileWriter(filePath, true); // 第二个参数为true表示追加写入
								writer.write(data); // 写入数据并换行
								writer.close();
								System.out.println("数据已成功写入文件。");
							} catch (IOException e) {
								System.out.println("写入文件时出现错误：" + e.getMessage());
							}
						//有记录过
						}else{
							for(int k = 0; k < detectParamlist.size(); k++)
							{
								if(detectParamlist.get(k).getLoacationID() == currenTaskParam.getLocationId() && detectParamlist.get(k).getItemID() == j)
								{
									//比对结果是否正确
									for(int n = 0; n < light_param.size(); n++)
									{
										if(detectParamlist.get(k).getParams().size() != light_param.size())
										{
											code = 5;      
											msg = "识别过程出错，检测结果异常";
											break;
										}
										Set_ItemParam temp = detectParamlist.get(k).getParams().get(n);
										//计算重叠度
										double res1 = calculateOverlapRatio(light_param.get(n).getX1(),light_param.get(n).getY1(),light_param.get(n).getX2(),light_param.get(n).getY2(),
										temp.getX1(),temp.getY1(),temp.getX2(),temp.getY2());
										//比较类别
										if(res1 > 0.8)
										{
											if(light_param.get(n).getCategory() == temp.getCategory())
											{
												if(temp.getCategory() == 0) //灯
												{
													if(!(temp.getColor() == light_param.get(n).getColor()))
													{
														if(code == 0)
														{
															code = 1;      //灯错误
															msg = "机器指示灯异常";
														}	
														System.out.println("错误");
													}
													else
													{
														System.out.println("正常");
													}
												}
												else if(temp.getCategory() == 1) //开关
												{
													if(!(temp.getSwitch_on_off() == light_param.get(n).getSwitch_on_off()))
													{
														if(code == 0)
														{
															code = 2;      //开关错误
															msg = "机器开关分合异常";
														}	
														System.out.println("错误");
													}
													else
													{
														System.out.println("正常");
													}
												}
												else if(temp.getCategory() == 2) //指针
												{
													if(light_param.get(n).getValue() != 0)
													{
														if(Math.abs(temp.getValue() - light_param.get(n).getValue()) > 10)   //设置阈值
														{
															if(code == 0)
															{
																code = 3;      //指针
																msg = "机器仪表指示异常";
															}
																
															System.out.println("错误");
														}
														else
														{
															System.out.println("正常");
														}
													}
												}
												else if(temp.getCategory() == 3) //数值
												{
													// if(!(temp.getValue2() / 10 == light_param.get(n).getValue2() / 10))
													// {
													// 	if(code == 0)
													// 	{
													// 		code = 4;      //数值
													// 		msg = "机器数值异常";
													// 	}
													// 	System.out.println("错误");
													// }
													// else
													// {
													// 	System.out.println("正常");
													// }
												}
											}
										}
									}
								}
							}
						}

						
						//HSV分析
						double v = Analysis_V(rgbpath);
				
						createFolder(baseDir+ "/audio");
						List<Double[]> wave = null;
						List<Double[]> fre = null;
						double maxTemp = 0;
							//获取音频 
						getAudio(ip2, baseDir + "/audio",Flag_new);

						//获取波形数据
						wave = WavDraw.ShowWave(baseDir+ "/audio");

						//获取频域数据
						fre = FFTCalc0ToEnd.ShowFre(baseDir+ "/audio");

						//红外分析
						if(Flag_new)
						{
							maxTemp = getMaxtemp(ip2);
						}		

						long endTime = System.currentTimeMillis();
						// 计算执行时间
						long executionTime = endTime - startTime;

						//摄像时间
						try{
							if(currenTaskItemParam.getRecordingTime() * 1000 - executionTime > 0)
								Thread.sleep(Math.abs(currenTaskItemParam.getRecordingTime() * 1000 - executionTime));
						}
						catch(Exception e)
						{
							throw new RuntimeException(e);
						}

						//停止录像时间
						Date Record_StopTime = new Date(System.currentTimeMillis());

						try{
							if(currenTaskItemParam.getResidenceTime() -currenTaskItemParam.getRecordingTime() > 0)
								Thread.sleep((Math.abs(currenTaskItemParam.getResidenceTime() -currenTaskItemParam.getRecordingTime())) * 1000);
						}
						catch(Exception e)
						{
							throw new RuntimeException(e);
						}
						//任务结束时间
						Date Task_StopTime = new Date(System.currentTimeMillis());
						back_result.setTaskId(taskId);
						back_result.setPointId(currenTaskParam.getPointId());
						back_result.setItemId(currenTaskItemParam.getItemId());
						back_result.setTaskStartTime(Task_StartTime);
						back_result.setTaskEndTime(Task_StopTime);
						back_result.setRecordStartTime(Record_StartTime);
						back_result.setRecordEndTime(Record_StopTime);
						back_result.setCode(code);
						back_result.setMsg(msg);
						back_result.setMaxTemp(maxTemp);
						back_result.setHSV_v(v);
						back_result.setFre(fre);
						back_result.setWave(wave);
						back_result.setParticleCounter_result(ParticleCounter_result);
						String resultpicture = baseDir+"/result/myexp3/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpg";
						back_result.setDetectResultRGB(getImageBytes(resultpicture));
						back_result.setDetectResultHeat(heat);
						//更新回调
						if(i == taskParams.size() -1 && j == taskItemParams.size() - 1){
							back_result.setIsOver(true);
							//停止录制
							Date Task_record_stop_time = new Date();
							if(Flag_new)
							{
								result = (JSONObject)stop_video_record_rgb(ip2).get("data");
								JSONObject result2 = (JSONObject)stop_video_record_heat(ip2).get("data");
								
								//可见光视频集的编号
								int rgb_record_id = (int)result.get("id");

								int heat_record_id = (int)result2.get("id");

								back_result.setRgb_download_id(rgb_record_id);
								back_result.setHeat_download_id(heat_record_id);
							}
							
							result = SetPanTiltPosture(ip2,initParam.getPan(),initParam.getTilt(),initParam.getZoom());
							if(initParam.getFliter() != null)
							{
								set_ctrl_lifter(ip, initParam.getFliter());
							}
							if(!Flag_new)
							{
								//关闭补光灯
								//switch_fill_light(ip2,false);
							}

							//任务执行完成，返回充电
							back_result.setIsDataCall(false);
							callable.call(back_result);
							//重置参数
							code = 0;
							msg = "";
							
							for(int s = route.size() - 1; s >= 0; s--)
							{
								//发送移动命令
								result = postMove(ip, route.get(s), open_doors);

								try{
									Thread.sleep(3000);
								}
								catch(Exception e)
								{
									throw new RuntimeException(e);
								}
								//等待移动完成
								while(true){
									result = (JSONObject)getRobotStatus(ip);
									JSONObject data = (JSONObject)result.get("data");
									String state = (String)data.get("state");
									if((int)result.get("code") != 0){
										code = (int)result.get("code");
										msg = (String)result.get("msg");
									}
									if((state.equals("StandingBy"))|| (state.equals("Charging")))
									{
										break;
									}
									else
									{
										try{
											Thread.sleep(1500);
										}
										catch(Exception e)
										{
											throw new RuntimeException(e);
										}
									}
								}
							}

							result = postMove(ip, -1, open_doors);

							while(true){
								result = (JSONObject)getRobotStatus(ip);
								JSONObject data = (JSONObject)result.get("data");
								String state = (String)data.get("state");
								if((int)result.get("code") != 0){
									code = (int)result.get("code");
									msg = (String)result.get("msg");
								}
								if((state.equals("Charging")))
								{
									break;
								}
								else
								{
									try{
										Thread.sleep(1500);
									}
									catch(Exception e)
									{
										throw new RuntimeException(e);
									}
								}
							}
							if(!Flag_new)
								//关门
								stop_opendoor(python_ip, port);
						}
						else{
							back_result.setIsOver(false);
							back_result.setIsDataCall(false);
							callable.call(back_result);
							//重置参数
							code = 0;
							msg = "";
						}

					}
					catch(Exception e){
						throw new RuntimeException(e);
					}
				
				}
			}
		}

	

		// try{
		// 	Thread.sleep(3000);
		// }
		// catch(Exception e)
		// {
		// 	throw new RuntimeException(e);
		// }

		return true;
	}

    //发送命令
	public static JSONObject post(JSONObject json, String url){
		String result = "";
		JSONObject jsStr = null;
		HttpPost post = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(60000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(60000) // 设置连接超时时间为 5 秒
    			.build();
		post.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			

			post.setHeader("Content-Type","application/json;charset=utf-8");
			post.addHeader("Authorization", "Basic YWRtaW46");
			StringEntity postingString = new StringEntity(json.toString(),"utf-8");
			post.setEntity(postingString);
			HttpResponse response = httpClient.execute(post);

			InputStream in = response.getEntity().getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
			StringBuilder strber= new StringBuilder();
			String line = null;	
			while((line = br.readLine())!=null){
				strber.append(line+'\n');
			}
			br.close();
			in.close();
			result = strber.toString();
			jsStr = JSONObject.fromObject(result);
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				result = "服务器异常";
				throw new RuntimeException();
			}
			//
		}catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//post.abort();
		}
		return jsStr;
	}

    //无参数的请求
	public static JSONObject get(String url){
		String result = "";
		JSONObject jsStr = null;
		HttpGet get = new HttpGet(url);
		RequestConfig requestConfig = RequestConfig.custom()
    			.setSocketTimeout(10000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(10000) // 设置连接超时时间为 5 秒
    			.build();
		get.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			

			HttpResponse response = httpClient.execute(get);
			
			//String responseBody = EntityUtils.toString(response.getEntity());
			result = getHttpEntityContent(response);
    		jsStr = JSONObject.fromObject(result);
            //System.out.println(jsStr.get("firstName"));
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				result = "服务器异常";
			}
			
			//response.close();
		} catch (Exception e){
			System.out.println("请求异常");

			throw new RuntimeException(e);
		} finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//get.abort();
		}
		return jsStr;
	}

	//获取返回内容
	public static String getHttpEntityContent(HttpResponse response) throws UnsupportedOperationException, IOException{
		String result = "";
		HttpEntity entity = response.getEntity();
		if(entity != null){
			InputStream in = entity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
			StringBuilder strber= new StringBuilder();
			String line = null;
			while((line = br.readLine())!=null){
				strber.append(line+'\n');
			}
			br.close();
			in.close();
			result = strber.toString();
		}

		return result;
	}

	//有参数的请求
	public static JSONObject get(JSONObject json, String url){
		String result = "";
		JSONObject jsStr = null;
		HttpGet get = new HttpGet(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try{
			
			// CloseableHttpClient httpClient = HttpClients.custom()
			//    .setConnectionManager(connectionManager)
			//    .setConnectionManagerShared(true) 
			//    .build();
			String param = URLEncoder.encode(json.toString(), "UTF-8");
			get.setURI(URI.create(url + "?json=" + param));
			HttpResponse response = httpClient.execute(get);
			result = getHttpEntityContent(response);
			jsStr = JSONObject.fromObject(result);
			if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
				result = "服务器异常";
			}
			
		} catch (Exception e){
			System.out.println("请求异常");
			throw new RuntimeException(e);
		} finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//get.abort();
		}
		return jsStr;
	}

	public static double calculateOverlapArea(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double overlapWidth = Math.min(x2, x4) - Math.max(x1, x3);
        double overlapHeight = Math.min(y2, y4) - Math.max(y1, y3);

        if (overlapWidth <= 0 || overlapHeight <= 0) {
            return 0; // 两个矩形不相交，重叠面积为0
        }

        return overlapWidth * overlapHeight;
    }

    public static double calculateOverlapRatio(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double rect1Area = (y2 - y1) * (x2 - x1);
        double rect2Area = (y4 - y3) * (x4 - x3);
        double overlapArea = calculateOverlapArea(x1, y1, x2, y2, x3, y3, x4, y4);

        return (double) overlapArea / (double) (rect1Area + rect2Area - overlapArea);
    }

	//开启检测服务
	public static void StartDetectService()
	{
		String line = "";
		try {
			System.out.println("start"); //D:/Software/anaconda/Scripts/activate.bat && conda activate myd2l && 
		
			//读取ini配置文件
			Ini ini = new Ini();
			try {
				// ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				// InputStream configStream = classLoader.getResourceAsStream("route_settings.ini"); 
				// ini.load(configStream);
				File inif = new File("src/main/java/com/ccdc/robot/domain/route_settings.ini");
				ini.load(inif);

			} catch (Exception e) {
				System.out.println("配置文件无法访问");
				e.printStackTrace();
			}
			String basedir = "";
			String workdir = "";
			String system = ini.get("option", "system");
			if(system.equals("windows"))
			{
				basedir = ini.get("windows", "basedir");
				workdir = basedir.split("/")[0];
			}
			else if(system.equals("linux"))
			{
				workdir = "";
			}
//python D:/Source/yolov5-v8.0/detect.py "D:/Source/yolov5-v8.0/runs/train/exp26/weights/best.pt" "D:/Source/yolov5-v8.0/runs/train/exp28/weights/best.pt" "D:/Source/yolov5-v8.0/runs/train/exp25/weights/best.pt" "D:/Source/yolov5-v8.0/runs/train/exp20/weights/best.pt" "D:/Source/192_168_33_158/result"
			


			String down = "python" + " "+ basedir + "yolov5-v8.0/detect.py" + " "+ basedir + "yolov5-v8.0/runs/train/exp26/weights/best.pt" + 
			" "+ basedir + "yolov5-v8.0/runs/train/exp28/weights/best.pt" + " "+ basedir + "yolov5-v8.0/runs/train/exp25/weights/best.pt" +
			 " "+ basedir + "yolov5-v8.0/runs/train/exp29/weights/best.pt";
			System.out.println(down);

			try {
				// 构建命令和参数列表
				ProcessBuilder processBuilder = new ProcessBuilder(
						"python",
						 basedir + "yolov5-v8.0/detect.py",
						basedir + "yolov5-v8.0/runs/train/exp26/weights/best.pt",
						basedir + "yolov5-v8.0/runs/train/exp28/weights/best.pt",
						basedir + "yolov5-v8.0/runs/train/exp25/weights/best.pt",
						basedir + "yolov5-v8.0/runs/train/exp29/weights/best.pt"
				);
	
				// 设置工作目录（可选）
				if(system.equals("windows"))
				{
					processBuilder.directory(new File(workdir));
				}
				
	
				// 启动进程并等待执行完成
				Process process = processBuilder.start();
				int exitCode = process.waitFor();
				// 读取命令输出
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line1;
				while ((line1 = reader.readLine()) != null) {
					System.out.println(line1);
				}

				// 检查命令是否执行成功
				if (exitCode == 0) {
					System.out.println("命令执行成功");
				} else {
					System.out.println("命令执行失败");
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{

		}
    }


	public static void callpython(String path,String path2, String path3 ,String py, String path4){
			String line = "";
			try {
				System.out.println("start"); //D:/Software/anaconda/Scripts/activate.bat && conda activate myd2l && 
				
			// 	try {
			// 	// 创建ProcessBuilder对象，并设置要执行的命令
			// 	ProcessBuilder pb = new ProcessBuilder("python", "-c", "import sys; print(sys.executable)");
			// 	// 启动进程并等待执行完成
			// 	Process process = pb.start();
			// 	process.waitFor();
				
			// 	// 读取命令行输出
			// 	BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			// 	String temp = "";
			// 	while ((temp = reader.readLine()) != null) {
			// 		//System.out.println("Python路径: " + line);
			// 		line += temp;
			// 	}
			// } catch (IOException | InterruptedException e) {
			// 	e.printStackTrace();
			// }
			//读取ini配置文件
			Ini ini = new Ini();
			try {
			
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				InputStream configStream = classLoader.getResourceAsStream("route_settings.ini"); 
				ini.load(configStream);
				// File inif = new File("src/main/java/com/ccdc/robot/domain/route_settings.ini");
				// ini.load(inif);

			} catch (Exception e) {
				System.out.println("配置文件无法访问");
				e.printStackTrace();
			}
			String basedir = "";
			String workdir = "";
			String system = ini.get("option", "system");
			if(system.equals("windows"))
			{
				basedir = ini.get("windows", "basedir");
				workdir = basedir.split("/")[0];
			}
			else if(system.equals("linux"))
			{
				workdir = "";
			}

			String down = "python" + " "+py+" "+path + " " + path2+ " " + path3 + " " + path4;
			System.out.println(down);

			try {
				// 构建命令和参数列表
				ProcessBuilder processBuilder = new ProcessBuilder(
						"python",
						py,
						path,
						path2,
						path3,
						path4
				);
	
				// 设置工作目录（可选）
				if(system.equals("windows"))
				{
					processBuilder.directory(new File(workdir));
				}
				
	
				// 启动进程并等待执行完成
				Process process = processBuilder.start();
				int exitCode = process.waitFor();
				// 读取命令输出
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line1;
				while ((line1 = reader.readLine()) != null) {
					System.out.println(line1);
				}

				// 检查命令是否执行成功
				if (exitCode == 0) {
					System.out.println("命令执行成功");
				} else {
					System.out.println("命令执行失败");
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}

			
            // Process pr=Runtime.getRuntime().exec(down);
            // BufferedReader in = new BufferedReader(new InputStreamReader(
            //         pr.getInputStream(),"GBK"));
            // String inline = null;
            // while ((inline = in.readLine()) != null) {
            //     // System.out.println(inline);
            // }
            // in.close();
            // int re = pr.waitFor();
            // System.out.println(re);
            // System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}