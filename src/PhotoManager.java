
public class PhotoManager {

    LinkedList<Photo> list;
    private BST<LinkedList<Photo>> allP; 
    // Constructor
    public PhotoManager() {
        list = new LinkedList<Photo>();
        allP = new BST<LinkedList<Photo>>();
    }
    // Add a photo

    public void addPhoto(Photo p) {
        list.findFirst();
        if(list.empty())
        	list.insert(p);
        else {
        while(!list.last()) {
        	if(p.getPath().equals(list.retrieve().getPath())) 
        		return;
        list.findNext();}
        
        if(p.getPath().equals(list.retrieve().getPath())) 
    		return;
        list.insert(p);
        }
        p.getTags().findFirst();
        if(p.getTags().empty()|| p.getTags()==null)
        	return;
        while(!p.getTags().last()) {
        	if(allP.findKey(p.getTags().retrieve()))
        		allP.retrieve().insert(p);
        	else {
        		allP.insert(p.getTags().retrieve(), new LinkedList<Photo>());
        		allP.retrieve().insert(p);
        	}
        	p.getTags().findNext();
        }
        
        if(allP.findKey(p.getTags().retrieve()))
    		allP.retrieve().insert(p);
    	else {
    		allP.insert(p.getTags().retrieve(), new LinkedList<Photo>());
    		allP.retrieve().insert(p);
    	}
           
    }      
// Delete a photo
    public void deletePhoto(String path) {
        LinkedList<String> Tags = new LinkedList<String>();

        if (!list.empty()) {

            list.findFirst();

            while (!list.last()) {
            	if(list.retrieve().getPath().equals(path)) {
                Tags=list.retrieve().getTags();
            	break;
            	} list.findNext();
            }
            if(list.retrieve().getPath().equals(path)) {
                Tags=list.retrieve().getTags();
            	list.remove(); 
            	}
        }
        else  return;
               Tags.findFirst();
               if(Tags.empty()||Tags==null)
            	   return;
               while (!Tags.last()) {
            	if(allP.findKey(Tags.retrieve())) {
            		LinkedList<Photo> LL = allP.retrieve();
            		LL.findFirst();
            		while(!LL.last()) {
            		if(LL.retrieve().getPath().equals(path)) {
            			LL.remove();
            			break;
            		}
            		LL.findNext();
            		}
            		if(!LL.empty()) 	
            		if(LL.retrieve().getPath().equals(path)) {
            			LL.remove(); 
            		}
            	if(LL.empty())
            		allP.removeKey(Tags.retrieve());
            			}
            	Tags.findNext();
            }
               if(allP.findKey(Tags.retrieve())) {
           		LinkedList<Photo> LL = allP.retrieve();
           		LL.findFirst();
           		while(!LL.last()) {
           		if(LL.retrieve().getPath().equals(path)) {
           			LL.remove(); 
           			break;
           			}
           		LL.findNext();
           		}
           		if(!LL.empty()) 
           		if(LL.retrieve().getPath().equals(path))
           			LL.remove();
           	if(LL.empty())
           		allP.removeKey(Tags.retrieve());
           			}    
    }
    

    public BST<LinkedList<Photo>> getPhotos() {
    return allP; 
}
public LinkedList<Photo> getlist() {
	return list;
}

}


