package freenet.node.updater;

import freenet.config.StringCallback;
import freenet.node.Node;
import freenet.support.Logger;

public class UpdateRevocationURICallback implements StringCallback{
	private final Node node;
		
	public UpdateRevocationURICallback(Node node) {
		this.node = node;
	}
	
	public String get() {
		NodeUpdater nu = node.getNodeUpdater();
		if (nu != null)
			return nu.getRevocationKey().toString(true);
		else
			return NodeUpdater.REVOCATION_URI;
	}

	public void set(String val) {
		if(val!=null && val.equals(get())) return;
		// Good idea to prevent it ? 
		//
		// Maybe it NEEDS to be implemented
		Logger.error(this, "Node's updater revocationURI can't be updated on the fly");
	}	
}
