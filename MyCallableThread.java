package com.k7it;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
 *  3rd way of thread creation : 
      by using Callable interface its available under 
      		java.util.concurrent package. it is part of Executable Service frame work. 
      		
      steps:
   1. create a class making sub class to Callable interface
   2. overrride or implements the call()
       synstax :
       
          public void run(){
          }
          
          public Object call() throws Exception{
          
          }
         
         Note: by using run() we can't return any value to caller once thread execution finish
         but if we use call() method from callable interface we can return some return value
         back to caller based on our requirements. 
         
         formula for sum of n numbers : n(n+1)/2
         
         Note2: in run() we can't handle the exceptions using throws key word, always we should
         use try and catch only, but in call() we can handle by using throws key as well.
         
         void run(){                                 Object call()throws InterruptedException{
             try{                                        sleep(1000)
             sleep(1000);                            }
             }catch(InterruptedException e){
             
             }
         
         }
         
   3. create array of MyCallableThread class objects
      
      MyCallableThread threads[] = {new MyCallableThread(20),new MyCallableThread(30),
                                        new MyCallableThread(40),new MyCallableThread(50),
                                        new MyCallableThread(60),new MyCallableThread(80)};
                                        
  4. create Executable service obj with thread pool size.
  
      ExecutorService service = Executors.newFixedThreadPool(int threadpoolSize);
      ExecutorService service = Executors.newFixedThreadPool(3);
      
      here threadpoolSize will decides how many thread we can save under pool . 
      
  5.  for each thread object invoke   service.submit(ourThread obj). this submit 
         
         Note: start() will call run() internally by using new thread, but run is having 
         return type  is void. we we no need to assing calling statement of t1.start() into
         a variable.
         
           	       t1.start();
           	   
         But in service.submit(); will call the call() internally by usning new thread but 
         this call method will return one return value to caller after finishing the thread
         task inside call() with type of Future class. 
         
           			Future future = service.submit(ourthreadobj);
           			
           	ExecutorService service = Executors.newFixedThreadPool(3);		
           for (MyCallableThread thread : threads) {
			Future future = service.submit(thread);
			System.out.println(future.get());
		  }
         
  
           output:
            execute by :pool-1-thread-1 for Sum of :20 numbers is
			210
			execute by :pool-1-thread-2 for Sum of :30 numbers is
			465
			execute by :pool-1-thread-3 for Sum of :40 numbers is
			820
			execute by :pool-1-thread-1 for Sum of :50 numbers is
			1275
			execute by :pool-1-thread-2 for Sum of :60 numbers is
			1830
			execute by :pool-1-thread-3 for Sum of :80 numbers is
			3240
			
			here we have given pool size is 3, so first three thread will saved into thread
			pool after finishing the task. next time onwards these 3 three threads will reuse
			for new task execution.

         
         
         
 */
public class MyCallableThread implements Callable{

	 int number;
	 MyCallableThread(int number){
		 this.number = number;
	 }
	@Override
	public Object call() throws Exception {
		System.out.println("execute by :"+Thread.currentThread().getName()+
				                       " for Sum of :"+number+" numbers is" );
		int sum=0;
		for (int i = 1; i <= number; i++) {
			sum+=i;
		}
		return sum;
	}

	 
}
