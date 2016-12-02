package hansExplorerMain;

public class EventRoom extends HansCaveRoom {
	
	private Event event;
	private boolean eventOccurred;
	
	public EventRoom(String description,Event e) {
		super(description);
		eventOccurred = false;
		this.event = e;
	}
	
	public void enter(){
		super.enter();
		if(!eventOccurred){
			eventOccurred = true;
			event.play();
		}
	}

}
