package com.ccdc.robot.callback;

import com.ccdc.robot.domain.TaskResult;

public interface TaskCallback {
        //回调函数
        public void call(TaskResult taskResult);
		 
}
