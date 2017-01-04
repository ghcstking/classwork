package twoDArraysDraft;

public class EventRoom extends CaveRoom {

	private boolean eventHappened;
	private Event event;
	
	public EventRoom(String description, Event event) {
		super(description);
		eventHappened = false;
		this.event = event;
	}

	public void enter(){
		super.enter();//sets contents to 'X'
		if(!eventHappened) {
			eventHappened = true;
			event.occur();
		}
		
	}
	
}
