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
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
		List<Integer> id = new ArrayList<>(Arrays.asList(1,2));

		//String result = getRobotStatus("192.168.33.158").toString();
		String ss = "{\"ip\":\"192.168.33.158\",\"taskId\":57,\"initParam\":{\"pan\":170,\"tilt\":60,\"zoom\":20},\"taskParamList\":[{\"pointId\":34,\"locationId\":2,\"itemList\":[{\"itemId\":40,\"pan\":30,\"tilt\":30,\"zoom\":25,\"residenceTime\":30,\"shotState\":true,\"recordingTime\":30}]},{\"pointId\":35,\"locationId\":1,\"itemList\":[{\"itemId\":41,\"pan\":30,\"tilt\":30,\"zoom\":25,\"residenceTime\":30,\"shotState\":true,\"recordingTime\":30}]},{\"pointId\":36,\"locationId\":6,\"itemList\":[{\"itemId\":42,\"pan\":30,\"tilt\":30,\"zoom\":25,\"residenceTime\":30,\"shotState\":true,\"recordingTime\":30}]}]}";
;		//JSONObject.toBean();
		JSONObject obj = JSONUtil.toBean(ss, JSONObject.class);
		InitParam param = new InitParam();
		List<TaskParam> param2 = new ArrayList<>();
		List<TaskItemParam> test = new ArrayList<>();

		TaskItemParam temp = new TaskItemParam();
		temp.setItemId(40l);
		temp.setPan(130f);
		temp.setTilt(30f);
		temp.setZoom(2f);
		temp.setRecordingTime(30);
		temp.setResidenceTime(35);
		temp.setShotState(true);

		TaskItemParam temp5 = new TaskItemParam();
		temp5.setItemId(40l);
		temp5.setPan(30f);
		temp5.setTilt(30f);
		temp5.setZoom(15f);
		temp5.setRecordingTime(30);
		temp5.setResidenceTime(35);
		temp5.setShotState(true);


		List<TaskItemParam> temp2 = new ArrayList<>();
		List<TaskItemParam> temp3 = new ArrayList<>();
		temp2.add(temp);
		temp3.add(temp5);
		try {
			 BeanUtils.copyProperties(param,obj.get("initParam"));
			    //test = JSONUtil.toList(JSONUtil.parseArray("[{/\"itemId/\":40,/\"pan/\":30,/\"tilt/\":30,/\"zoom/\":25,/\"residenceTime/\":30,/\"shotState/\":true,/\"recordingTime/\":30}]"), TaskItemParam.class);
			    //param2 = BeanUtil.copyToList(obj.getJSONArray("taskParamList"),TaskParam.class);	
			//  param2.get(0).setItemList(JSONUtil.toList("[{/\"itemId/\":40,/\"pan/\":30,/\"tilt/\":30,/\"zoom/\":25,/\"residenceTime/\":30,/\"shotState/\":true,/\"recordingTime/\":30}]", TaskItemParam.class));	
		    //  param2.get(1).setItemList(JSONUtil.toList("[{/\"itemId/\":40,/\"pan/\":30,/\"tilt/\":30,/\"zoom/\":25,/\"residenceTime/\":30,/\"shotState/\":true,/\"recordingTime/\":30}]", TaskItemParam.class));	
 			//  param2.get(2).setItemList(JSONUtil.toList("[{/\"itemId/\":40,/\"pan/\":30,/\"tilt/\":30,/\"zoom/\":25,/\"residenceTime/\":30,/\"shotState/\":true,/\"recordingTime/\":30}]", TaskItemParam.class));	
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		param.setPan(40f);

		TaskParam task = new TaskParam();
		task.setItemList(temp2);
		task.setLocationId(6);
		task.setPointId(34l);
		param2.add(task);

		TaskParam task1 = new TaskParam();
		task1.setItemList(temp3);
		task1.setLocationId(1);
		task1.setPointId(35l);
		// SetPanTiltPosture("10.255.22.158",90f,20f,2f);

		// for(int i = 0 ; i < 6; i++)
		// {
		// 	float x = i*10 - 20;
		// 		try{
		// 					Thread.sleep(3* 1000);
		// 			}
		// 			catch(Exception e)
		// 			{
		// 				throw new RuntimeException(e);
		// 			}
		// 	SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		// 	Date date = new Date();
		// 	String rgbpath = "D:\\Source\\image\\" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpeg";
		// 	try {
		// 		File targetDir = new File(rgbpath);
		// 		if(!targetDir.exists()){
		// 			targetDir.createNewFile();
		// 		}
		// 	} catch (Exception e) {
		// 		// TODO: handle exception
		// 		e.printStackTrace();
		// 	}
		
			
		// 	getRGB("10.255.22.158",rgbpath);
		// }
		// while(true)
		// {
		// 	String sre = getRobotStatus("10.255.22.158").toString();
		// 					try{
		// 					Thread.sleep(1000);
		// 			}
		// 			catch(Exception e)
		// 			{
		// 				throw new RuntimeException(e);
		// 			}
				
		// 	System.out.println(sre);
		// }


		//SetPanTiltPosture("10.255.22.158",-90f,10f,1f);

		

		// SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		// Date date = new Date();
		// String rgbpath = "D:\\Source\\image\\" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpeg";
		// try {
		// 	File targetDir = new File(rgbpath);
		// 	if(!targetDir.exists()){
        //     	targetDir.createNewFile();
       	// 	}
		// } catch (Exception e) {
		// 	// TODO: handle exception
		// 	e.printStackTrace();
		// }
		
		
		// getRGB("10.255.22.158",rgbpath);
							//获取波形数据
		// List<Double[]> wave = WavDraw.ShowWave("D:/Source/192_168_33_158/audio" );

		// System.out.println(wave.size() + "12");
		// 			//获取频域数据
		// List<Double[]> fre = FFTCalc0ToEnd.ShowFre("D:/Source/192_168_33_158/audio");

		// System.out.println(fre.size() + "dd");

		//param2.add(task1);

		// param2.get(0).setLocationId(2);
		// param2.get(0).setPointId(34l);
		// param2.get(0).setItemList(temp2);
		// param2.get(1).setItemList(temp2);
		// param2.get(1).setLocationId(1);
		// param2.get(1).setPointId(35l);

		//byte[] res = getRGBPicture("10.255.22.158");

		


		// param2.get(2).setItemList(temp2);
		// param2.get(2).setLocationId(6);
		// param2.get(2).setPointId(36l);
		//StartTask("10.255.22.158",1l,obj.getLong("taskId"),param,param2);		//String result = getRobotStatus("192.168.43.158").toString();
       	//postMove("10.255.22.158", -1);
		//System.out.println(result);
		//Analysis_V("D:\\Source\\image\\2023_10_24_05_53_32.jpeg");
		//String res = clearError("10.255.22.158").toString();
		//System.out.println(res);
		//postTakeOver("10.255.22.158");

		//deleteFilesInFolder("D:/Source/image");

		// postMove("10.255.22.92", -1);
		
		// try{
		// 				Thread.sleep(1500);
		// 			}
		// 			catch(Exception e)
		// 			{
		// 				throw new RuntimeException(e);
		// 			}
		// //等待移动完成
		// 	while(true){
		// 		JSONObject result = (JSONObject)getRobotStatus("10.255.22.92");
		// 		JSONObject data = (JSONObject)result.get("data");
		// 		String state = (String)data.get("state");
		// 		if((int)result.get("code") != 0){
		// 			int code = (int)result.get("code");
		// 			String msg = (String)result.get("msg");
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

		// SetPanTiltPosture("10.255.22.92",-75f,23f,3f);

		// SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		// Date date = new Date();
		// String rgbpath = "D:\\Source\\image\\" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpeg";
		// try {
		// 	File targetDir = new File(rgbpath);
		// 	if(!targetDir.exists()){
        //     	targetDir.createNewFile();
       	// 	}
		// } catch (Exception e) {
		// 	// TODO: handle exception
		// 	e.printStackTrace();
		// }
		// getRGB("10.255.22.92",rgbpath);


		//postStopTakeOver("10.255.22.158",true);

		//JSONObject result = getRobotStatus("10.255.22.158");

		// JSONObject data = (JSONObject)getRobotStatus("192.168.88.4").get("data");

		// String state = (String)data.get("state");

		// boolean fa = ((state.equals("Charging"))) ;
		//System.out.println(result);
		//callpython("D:/Source/192_168_33_158/image/20230924195545.jpg", "D:/Source/192_168_33_158/result", "D:/Source/yolov5-v8.0/runs/train/exp13/weights/best.pt", "D:/Source/yolov5-v8.0/detect_light.py");
		//callpython("D:/Source/192_168_33_158/image/20230924195545.jpg", "D:/Source/192_168_33_158/result", "D:/Source/yolov5-v8.0/runs/train/exp13/weights/best.pt", "D:/Source/yolov5-v8.0/detect_light.py");

		//callpython("D:\\Source\\image\\" + "2023_10_24_05_53_51.jpeg", "D:/Source/192_168_33_158/result", "D:/Source/yolov5-v8.0/runs/train/exp13/weights/best.pt", "D:/Source/yolov5-v8.0/detect_light.py","");
		//callpython("D:\\Source\\image\\" + "2023_10_24_05_53_51.jpeg" , "D:/Source/192_168_33_158/result", "D:/Source/yolov5-v8.0/runs/train/exp24/weights/best.pt", "D:/Source/yolov5-v8.0/detect_switch.py","");
		//callpython("D:/Source/192_168_33_158/result/myexp2/" + "IMG20230905143915.jpg", "D:/Source/192_168_33_158/result", "D:/Source/yolov5-v8.0/runs/train/exp21/weights/best.pt", "D:/Source/yolov5-v8.0/detect_pointer.py","")
		//callpython("D:\\Source\\image\\2023_10_26_04_49_30.jpeg", "D:/Source/192_168_33_158/result", "D:/Source/yolov5-v8.0/runs/train/exp25/weights/best.pt", "D:/Source/yolov5-v8.0/detect_num_pointer(2).py","D:/Source/yolov5-v8.0/runs/train/exp20/weights/best.pt");
		// List<Integer> try1 = new ArrayList<>();
		// try1.add(1105);
		// try1.add(1106);
		// try1.add(1109);
		// try1.add(1111);
		// getRoutePlan("10.255.22.92", try1, 0.4);

		// List<Double[]> wave = FFTCalc0ToEnd.ShowFre("D:/Source/10_255_22_158" + "/audio");

		// List<Double[]> wave1 = WavDraw.ShowWave("D:/Source/10_255_22_158" + "/audio");
		
		// int i = 0;
		// JSONObject res = (JSONObject)postDetectlight("127.0.0.1", "D:/Source/image/2023_10_29_03_53_49.jpeg");
		
		// System.out.println(res);


		//python D:/Source/yolov5-v8.0/detect.py "D:/Source/yolov5-v8.0/runs/train/exp26/weights/best.pt" "D:/Source/yolov5-v8.0/runs/train/exp28/weights/best.pt" "D:/Source/yolov5-v8.0/runs/train/exp25/weights/best.pt" "D:/Source/yolov5-v8.0/runs/train/exp20/weights/best.pt" "D:/Source/192_168_33_158/result"
		
		// Runnable taskn = new Runnable() {
		// 	@Override
		// 	public void run() {
		// 		// 函数要执行的代码
		// 		StartDetectService();
		// 	}
		// };

		// ExecutorService executor = Executors.newSingleThreadExecutor();

        // // 提交任务给线程池执行
        // executor.submit(taskn);


		JSONObject res = (JSONObject)postDetectlight("127.0.0.1", "D:/Source/image/2023_10_29_03_53_49.jpeg","D:\\Source\\192_168_33_158\\result");
		System.out.println(res);

		// String folderPath = "D:\\Source\\image";
        // File folder = new File(folderPath);
        // if (folder.isDirectory()) {
        //     listFilesForFolder(folder);
        // } else {
        //     System.out.println("指定路径不是一个有效的文件夹!");
        // }

		//executor.shutdown();
	}

	public static void listFilesForFolder(final File folder) {
		int i = 0;
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
				i++;
                //System.out.println(fileEntry.getAbsolutePath());
				JSONObject res = (JSONObject)postDetectlight("127.0.0.1", fileEntry.getAbsolutePath(),"D:\\Source\\192_168_33_158\\result");
				String paht = (String)res.get("save_path");

				File sourceFile = new File(paht);
				File destFile = new File("D:/Source/result/" + String.valueOf(i) + ".jpeg");

				// 判断源文件是否存在
				if (sourceFile.exists()) {
					// 判断目标文件路径所在的目录是否存在，如果不存在，则创建该目录
					File destDir = destFile.getParentFile();
					if(!destDir.exists()){
						destDir.mkdirs();
					}

					// 执行文件复制的操作
					try {
						Files.copy(sourceFile.toPath(), destFile.toPath());
						System.out.println("文件复制成功！");
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("源文件不存在！");
				}
				System.out.println(res);
			}
        }
    }

	//发送检测指令(ok)
	public static JSONObject postDetectlight(String ip,String image_path,String save_path){

		Ini ini = new Ini();
		try {
			// ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			// InputStream configStream = classLoader.getResourceAsStream("route_settings.ini"); 
			// ini.load(configStream);
			File inif = new File("robotapi_2/src/main/java/com/ccdc/robot/domain/route_settings.ini");
			ini.load(inif);

		} catch (Exception e) {
			System.out.println("配置文件无法访问");
			e.printStackTrace();
		}
		String port = ini.get("option", "port");

		String url = "http://" + ip + ":"+ port + "/predictlight";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("path", image_path);
		jsonObject2.put("result", save_path);
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

	//获取路径和时间信息(ok)
	@SuppressWarnings("unchecked")
    public static JSONObject getRoutePlan(String ip, List<Integer> id, Double speed){
        String url = "http://" + ip + ":35181/beepatrol/plan";
		List<Integer> Route = new ArrayList<>();
		double time = 0;
		double denstense = 0;
		JSONArray path = new JSONArray();
        //JSONObject result = Robot_API.get(url);
		for(int i = 0; i < id.size() - 1; i++){
    		int  from = id.get(i);
    		int  to = id.get(i + 1);
			List<Integer> open_doors = new ArrayList<>();
			//open_doors.clear();
			
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("from", from);
			jsonObject2.put("to", to);
			//jsonObject2.put("open_doors", open_doors);
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
	public static JSONObject postMove(String ip, int id){
		String url = "http://" + ip + ":35181/beepatrol/move";
		List<Integer> open_doors = new ArrayList<>();
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
	public static byte[] getRGBPicture(String ip){
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
	public static byte[] getheat(String ip){
		String url = "http://" + ip + ":35182/beepatrol/shot_heatmap";
		ByteArrayOutputStream os = null;
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("data", 0);
		InputStream in = null;
		URI uri = null;
		
		try{
			uri = new URIBuilder(url)
					.setParameter("id", String.valueOf(1)).build();
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
				byte[] buffer = new byte[1024];
            	int bytesRead;
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

	//获取音频流
	public static void getAudio(String ip,String path)
	{	

		ByteArrayInputStream inputStream1 = null;
		FileOutputStream outStream = null;
		String url = "rtsp://" + ip + ":8554/audio";

		String outputFilePath = path  + "/out.aac";
		String outputFilePath2 = path  + "/out.wav";

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
	
		String[] ffmpegCommand = {
			"ffmpeg",
			"-i",
			url,
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
	public static Boolean StartTask(TaskCallback callable,String ip, Long PlanID, Long taskId, InitParam initParam, List<TaskParam> taskParams,int tasktype){
		
		int code = 0;
		String msg = "";
		Boolean hava_store = false;
		TaskResult back_result = new TaskResult();
		JSONObject result = new JSONObject();

		String sourceDir = "";

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
		if(system.equals("windows"))
		{
			sourceDir = ini.get("windows", "basedir");
		}
		else if(system.equals("linux"))
		{
			sourceDir = ini.get("linux", "basedir");
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
		start_video_record_rgb(ip);
		start_video_record_heat(ip);

		//初始化机器人
		result = SetPanTiltPosture(ip,initParam.getPan(),initParam.getTilt(),initParam.getZoom());
		if((int)result.get("code") != 0){
			code = (int)result.get("code");
			msg = (String)result.get("msg");
		}
		
		//等待初始化完成
		try{
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}	

		for(int i = 0; i < taskParams.size(); i++)
		{
			TaskParam currenTaskParam = taskParams.get(i);

			//处理巡检点

			//发送移动命令
			result = postMove(ip, currenTaskParam.getLocationId());
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
			//执行任务节点
			List<TaskItemParam> taskItemParams = currenTaskParam.getItemList();
			for(int j = 0; j < taskItemParams.size(); j++)
			{	
				try{
					//开始执行任务时间
					Date Task_StartTime = new Date(System.currentTimeMillis());
					
					TaskItemParam currenTaskItemParam = taskItemParams.get(j);
					
					long startTime = System.currentTimeMillis();

					//设置云盘
					SetPanTiltPosture(ip,currenTaskItemParam.getPan(),currenTaskItemParam.getTilt(),currenTaskItemParam.getZoom());

					//等待云盘设置成功
					// try{
					// 	Thread.sleep(2000);
					// }
					// catch(Exception e)
					// {
					// 	throw new RuntimeException(e);
					// }
					//开始录像时间
					Date Record_StartTime = new Date(System.currentTimeMillis());

					//System.getProperty("user.dir");
					createFolder(baseDir);
					//拍照
					Date date = new Date();
					deleteFilesInFolder(baseDir + "/image");
					createFolder(baseDir+ "/image");
					SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
					File targetDir = new File(baseDir+ "/image/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpeg");
					if(!targetDir.exists()){
            			targetDir.createNewFile();
        			}
					String rgbpath = baseDir + "/image/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpeg";
					getRGB(ip,rgbpath);			

					deleteFilesInFolder(baseDir+ "/result");
					createFolder(baseDir+ "/result");

					//识别可见光图片
					JSONObject res = (JSONObject)postDetectlight("127.0.0.1", rgbpath,baseDir+"/result");
					System.out.println(res);
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
					
					//红外分析
					double maxTemp = getMaxtemp(ip);

					createFolder(baseDir+ "/audio");
					//获取音频 
					getAudio(ip, baseDir + "/audio");

					//获取波形数据
					List<Double[]> wave = WavDraw.ShowWave(baseDir+ "/audio");

					//获取频域数据
					List<Double[]> fre = FFTCalc0ToEnd.ShowFre(baseDir+ "/audio");

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
					String resultpicture = baseDir+"/result/myexp3/" + dateFormat.format(date).replace(' ', '_').replace(':', '_').replace('-', '_') + ".jpeg";
					back_result.setDetectResultRGB(getImageBytes(resultpicture));
					//更新回调
					if(i == taskParams.size() -1 && j == taskItemParams.size() - 1){
						back_result.setIsOver(true);
						//停止录制
						Date Task_record_stop_time = new Date();
						result = (JSONObject)stop_video_record_rgb(ip).get("data");
						JSONObject result2 = (JSONObject)stop_video_record_heat(ip).get("data");
						
						//可见光视频集的编号
						int rgb_record_id = (int)result.get("id");

						int heat_record_id = (int)result2.get("id");

						back_result.setRgb_download_id(rgb_record_id);
						back_result.setHeat_download_id(heat_record_id);

						result = SetPanTiltPosture(ip,initParam.getPan(),initParam.getTilt(),initParam.getZoom());

						//任务执行完成，返回充电
						result = postMove(ip, -1);
					}
					else{
						back_result.setIsOver(false);
					}
					callable.call(back_result);
					//重置参数
					code = 0;
					msg = "";
				}
				catch(Exception e){
					throw new RuntimeException(e);
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
    			.setSocketTimeout(10000) // 设置 socket 超时时间为 5 秒
    			.setConnectTimeout(10000) // 设置连接超时时间为 5 秒
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