
public class AlertSubmitSynchronizer {
	private Object alertSubmitLock = new Object();
	private boolean alertSubmitDone = false;
	private static AlertSubmitSynchronizer instance;
	
	private AlertSubmitSynchronizer() {
		
	}

	public static AlertSubmitSynchronizer getInstance() {
		if(instance == null) 
			instance = new AlertSubmitSynchronizer();
		return instance;
	}

	public boolean isAlertSubmitDone() {
		return alertSubmitDone;
	}

	public void setAlertSubmitDone(boolean alertSubmitDone) {
		this.alertSubmitDone = alertSubmitDone;
	}

	public Object getAlertSubmitLock() {
		return alertSubmitLock;
	}

	
}
