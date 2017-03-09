package battlePackage;

import java.util.List;

public class ActionDuration implements Runnable {
	
	String specificAction;
	Character targeter;
	Character target;
	boolean running = true;
	

	








  public void stop() {
	  running=false;
  }
  
  public void resume() {
	  running=true;
  }




	@Override
	public void run() {
		while (true && target.getHealth()>0) {
			try {
			while (running) {
					switch (specificAction) {
					case "attack":
						targeter.normalAttack(target);
						System.out.println(target.getHealth());
							Thread.sleep((long) (targeter.getAttackDelay()*1000));
						
						break;
		
					default:
						break;
					}
				}
				Thread.sleep(10);
			} catch (InterruptedException e) {
				break;
			}
		} 
		
	}


	
		
	}


