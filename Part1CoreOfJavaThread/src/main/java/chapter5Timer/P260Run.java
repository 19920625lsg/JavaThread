/***********************************************************
 * @Description : 定时时间早于当前时间，直接运行,而且没执行地任务会补回来
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 下午10:59
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter5Timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class P260Run {
    private static Timer timer = new Timer();

    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("1 begin 运行了！时间为：" + new Date());
            System.out.println("1   end 运行了！时间为：" + new Date());
        }
    }

    public static void main(String[] args) throws ParseException {
        MyTask task = new MyTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2018-04-10 23:06:00";
        Date dateRef = sdf.parse(dateString);
        System.out.println("字符串时间为：" + dateRef.toLocaleString() + ", 当前时间为：" + new Date().toLocaleString());
        timer.scheduleAtFixedRate(task, dateRef, 5000);
    }
}
