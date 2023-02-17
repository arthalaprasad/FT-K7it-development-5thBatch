package com.k7it;

public class ThreadDemo {
	
	/*
	 
	 Mythread t1 = new Mythread();
	  t1.setName("MyThread");
	  t1.start();
	  //t1.run();
	  for (int i = 100; i < 200; i++) {
		System.out.println(Thread.currentThread().getName()+":"+i);
	   }
	   
	   
	  getName(): this method will give the current thread name, in java every thread will have 
	  unique ID and name as default name, thread name will start with "Thread-index"  here index will start from
	  0 and end with n-1, for example if we have 3 threads then names of those threads are like 
	  this Thread-0, Thread-1, Thread-2. these names called as default names. 
	  Note: name of the main thread is  "main".
	  
	     public static void main(String[] args) {
	    	System.out.println(Thread.currentThread().getName()); // main
	    }
	    
	  if we dont default name we can give user define name for our threads by using setName();
	  
	  setName(String name): by using setName() we can set the user defined name for our threads.
	  
	  isDaemon(): this method will return boolean value if current read is Daemon thread it 
	  will return boolean true else it will return boolean false. 
	  	  
	  setDaemon(boolean flag): by using this method we can convert user thread into daemon thread
	  by passing boolean true value as input parameter. 
	  
	  
	  
	  MyRunnableThread mytherad = new MyRunnableThread();
	  Thread t1 = new Thread(mytherad);
	  t1.setDaemon(true);
	  t1.start();
	  System.out.println("is our thread i sdaemon thread:"+t1.isDaemon());
	  for (int i = 100; i < 200; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		   }	  
  		}
  		
  		public class MyRunnableThread implements Runnable {
			@Override
			public void run() {
				//Thread.currentThread().setDaemon(true);
				System.out.println("is our thread is daemon thread:"+Thread.currentThread().isDaemon());
				for(int i =1000;i<2000000;i++){
					System.out.println(Thread.currentThread().getName()+":"+i);
					}
			}
		}
    output: 
    main:1
is our thread i sdaemon thread:true
main:2
Thread-0:1000
main:3
Thread-0:1001
main:4
Thread-0:1002
main:5
Thread-0:1003
main:6
main:7
main:8
Thread-0:1004
Thread-0:1005
Thread-0:1006
Thread-0:1007
Thread-0:1008
Thread-0:1009
Thread-0:1010
Thread-0:1011
Thread-0:1012
Thread-0:1013
Thread-0:1014
Thread-0:1015
Thread-0:1016
Thread-0:1017
Thread-0:1018
main:9
main:10
main:11
main:12
main:13
main:14
main:15
main:16
main:17
main:18
main:19
main end
Thread-0:1019
Thread-0:1020
Thread-0:1021
Thread-0:1022
Thread-0:1023
Thread-0:1024
Thread-0:1025


 Note: child thread suppose to print 1000 to 20000 but is it a daemon thread, so it is stopping 
 middle of the work once main thread task is completed. 
 
       MyRunnableThread mytherad = new MyRunnableThread();
	  Thread t1 = new Thread(mytherad);	  
	  t1.start();
	  t1.setDaemon(true);// CS but RTE i.e IllegalStateException  we can't convert user thread to daemon 
	  thread after starting the thread, we have decide before start the thread. 
	  
     
	  how to make parent thread to wait for completion of daemon child thread task: 
	  
	  join() throws InterruptedException: by uisng join() we can make parent thread to wait for completion of child thread
	  task even though parent thread task is completed.  here join() will produce one checked type
	  exception i.e InterruptedException. if we want to use join() we should used under try
	  catch or we use throws key word. 
	    
	         MyRunnableThread mytherad = new MyRunnableThread();
	  Thread t1 = new Thread(mytherad);
	  t1.setDaemon(true);
	  t1.start();
	 
	  for (int i = 1; i < 20; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		   }	  
        t1.join();
        System.out.println("main end");
        
        
        output:
        
	    main:1
			is our thread i sdaemon thread:true
			main:2
			Thread-0:1000
			main:3
			Thread-0:1001
			main:4
			Thread-0:1002
			main:5
			Thread-0:1003
			main:6
			main:7
			main:8
			Thread-0:1004
			Thread-0:1005
			Thread-0:1006
			Thread-0:1007
			Thread-0:1008
			Thread-0:1009
			Thread-0:1010
			Thread-0:1011
			Thread-0:1012
			Thread-0:1013
			Thread-0:1014
			Thread-0:1015
			Thread-0:1016
			Thread-0:1017
			Thread-0:1018
			main:9
			main:10
			main:11
			main:12
			main:13
			main:14
			main:15
			main:16
			main:17
			main:18
			main:19
			
			Thread-0:1019
			Thread-0:1020
			Thread-0:1021
			Thread-0:1022
			Thread-0:1023
			Thread-0:1024
			Thread-0:1025
			.
			.
			.
			Thread-0:1999999
			child end
			main end
			
			join(int milliSec): this method makes parent thread wait for child thread with
			  specified millisec's of time, once specified time is over either child thread is
			  Completed the task or not parent will go away. 	
			  
			    
	       getId(): getId() we will get the thread id , by default thread id will start with 
	          15 for child threads and it will increase by 1 for each new thread 16, 17, 18...
	           but id for the main thread is always : 1
	           
	            public static void main(String[] args) throws InterruptedException {
	
					  System.out.println();
					  MyRunnableThread mytherad = new MyRunnableThread();
					  Thread t1 = new Thread(mytherad);
					  t1.setDaemon(true);
					  t1.start();
					  
					  Mythread t2 = new Mythread();
					  t2.start();
					  
					 
					  for (int i = 1; i < 20; i++) {
							System.out.println("Name:"+Thread.currentThread().getName()+
									",ID:"+Thread.currentThread().getId()+":"+i);
						   }	  
				        t1.join();
				        System.out.println("main end");
				  
				  }
				  
				  
				  public class Mythread extends Thread {
				
					@Override
					public void run() {
						for (int i = 0; i < 100; i++) {
							System.out.println("Name:"+Thread.currentThread().getName()+
									",ID:"+Thread.currentThread().getId()+":"+i);
						}
					}
				}
				
				public class MyRunnableThread implements Runnable {
				
					@Override
					public void run() {
						//Thread.currentThread().setDaemon(true);
						System.out.println("is our thread i sdaemon thread:"+Thread.currentThread().isDaemon());
						for(int i =1000;i<2000;i++){
							System.out.println("Name:"+Thread.currentThread().getName()+
									",ID:"+Thread.currentThread().getId()+":"+i);
							
							}
						System.out.println("child end");
						
					}
				
				}
       output: 
	        
	        
		is our thread i sdaemon thread:true
		Name:main,ID:1:1
		Name:Thread-0,ID:15:1000
		Name:Thread-1,ID:16:1
		Name:Thread-0,ID:15:1095
		Name:Thread-0,ID:15:1096
		........
		
		child end
		main end
      
      
        Thread priority : 
        =================
              in java we have thread priority between 1 to 10, based on this priority 
              thread scheduler will decide which thread needs to execute first. 
                  in this we have 3 priroty constants in thread like below:
                  
                 	  MIN_PRIORITY = 1;
				      NORM_PRIORITY = 5;
				      MAX_PRIORITY = 10;
		   here default priority is NORM_PRIORITY i.e 5 		       
				      
	      getPriority():  by using getPriority() we can get the priority of thread. by 
	      default every thread will have normal priority i.e 5.
	      
	       System.out.println("main thread priority:"+Thread.currentThread().getPriority());  
	       
	       
	      setPriroty(): by using setPriority we can set the priority for thread which is user 
	       wants to set between 1 to 10. based on this priority only thread scheduler will 
	       decide which thread will come for execution. 
	          
	           Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
	             or 
	           Thread.currentThread().setPriority(10);
	          
	          
			  MyRunnableThread mytherad = new MyRunnableThread();
			  Thread t1 = new Thread(mytherad);
			  t1.setDaemon(true);
			  t1.setPriority(1);
			  t1.start();
			  
			  Mythread t2 = new Mythread();
			  t2.setPriority(10);
			  t2.start();
			  
			 System.out.println("main thread priority:"+Thread.currentThread().getPriority());
			  for (int i = 1; i < 20; i++) {
					System.out.println("Name:"+Thread.currentThread().getName()+
							",ID:"+Thread.currentThread().getId()+":"+i);
				   }	  
		        t1.join();
		        System.out.println("main end");
			  
			  output:
			   child1 thread priority:1
				main thread priority:10
				child2 thread priority:10
				is our thread is daemon thread:true
				Name:main,ID:1:1
				Name:main,ID:1:2
				Name:Thread-1,ID:16:20
				Name:main,ID:1:3
				Name:Thread-0,ID:15:40
				Name:main,ID:1:4
				
		  Thread Life Cycle: 
		  =================
		  
		  new born state: when ever we create the object for our thread class it will be 
		                  under new born state
		                  
		                   Mythread t2 = new Mythread(); 
		                   
		         when ever we will invoke start() by using our thread class object, start()
		         method will perform 2 actions 
		              1. giving thread features to our class object 
		              2. moving thread from new born state to Active State.
		        
		         Active state: any thread which is ready for execution after invoke start()
		                       method. it will come to Runnable under active state. 
		                       then it will register with ThreadScheduler for CPU/processor
		                       time slot allocations. 
		                       
		                      i. Runnable state: the threads which are waiting for cpu turn 
		                                          those thread are waiting under Runnable state
		                      ii. Running state: the Thread which one got the cpu time slot allocation
		                                          by threadScheduler , that thread will move from runnable 
		                                          state to Running state. it will use CPU for specified 
		                                          number of milli sections or micro secs. 
		                                          
		                                          if thread will complete the given task with in given
		                                          cpu time it will goes to death state automatically 
		                                          this is called normal death. 
		                                          
		                                          if thread is not competed the given task with in
		                                          cpu time slot then that thread will come back to Runnable
		                                          and it will wait for next cpu turn to complete the pending 
		                                          task.
		                                          
		                                          here 
		                                          note1: suppose if we want bring any of the thread running state
		                                           to runnable state forcefully before finishing the cpu time slot 
		                                           then we should use the yield() method. 
		                                           
		                                          Note2: suppose if we want to kill the any of thread before finishing 
		                                           given task forcefully then we can use stop(). 
		                                           
		               3. blocked/waiting state: if any of the threads which doesn't have 
		                        sufficient resources to continue its work even though that 
		                        thread will get cpu time slot, those thread its not advisable
		                        to keeping in active state, because it will wast the cpu time,
		                        those type of thread we should bring active state to blocked state
		                        by using either of following methods  
		                            1. wait()   -- notify()/notifyAll()
		                            2. suspend()
		                            3. sleep() 
		                            
		                         Note1 for wait(): we want to bring any of the thread from blocked state to active 
		                         state the thread which is went to blocked state by uisng wait(), for those
		                         threads we should use notify()/ notifyAll() methods to bring back to 
		                         active state.
		                         
		                            notify(): this method will  bring only one thread from blocked state 
		                                     to active state. 
		                                     for example if 10 threads went to the blocked state by using 
		                                     wait(), from 10 threads this notify() will bring only one 
		                                     thread back to active state, remaining 9 threads still in 
		                                     the blocked state only.
		                                  
		                            notifyAll():  this will bring all threads from blocked state to active state which
		                                          are went to blocked state by using wait().
		                                          
		                            
		                            
		                            suspend(): if any of the thread went to active state to blocked state by using suspend().
		                             if we want to bring that thread back to active state means we should use resume().
		                             
		                                  here suspend() and resume() methods are deprecated/ old methods /legacy methods.
		                                  so its not advisable to use this methods now a days.
		                            
		                                           
		                            sleep(int milliSec): if we use the sleep() to bring any of the thread to active state to
		                                 blocked state, those threads will come back automatically once specified sleeping 
		                                  time over. 
		                                  
		                                                  
		                              Note: these all methods which are using to bring thread from active state to blocked
		                                    state or which are using to making one to waiting state. those methods 
		                                    will produce one check type exception i.e 
		                                    
		                                        java.lang.InteruptedException 
		                                        
		                               so if we want to use these methods inside our program we should use wait in 
		                                try and catch(InteruptedException) or that method should throws InteruptedException.
		                                                                  
		        4. death state: if thread is finished the given task then that thread will
		           goes to death state or end state. this is called normal death. 
		           but if we want to kill any of the thread before finishing given task 
		           forcefully   then we should use stop().  
		           
		        CPU Scheduling Algorithms:  
		        ===============================  
		      	First Come, First Served (FCFS)
				Shortest Job Next (SJN) 
				Priority Scheduling
				Shortest Remaining Time
				Round Robin (RR) scheduling
				Multilevel Queues                
		   
		  
	       
	 */
	
  public static void main(String[] args) throws InterruptedException {
	
	    OddNumerThread ot =  new OddNumerThread();
	    ot.start();
	    
	    EvenNumberThread et = new EvenNumberThread();
	    et.start();  
	   
        System.out.println("main end");
  
  }
  
      
}
