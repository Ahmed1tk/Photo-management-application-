
public class Album {
    // Constructor

    private String albumName;
    private String condition;
    private PhotoManager manager;

    public Album(String name, String condition, PhotoManager manager) {
        this.albumName = name;
        this.condition = condition;
        this.manager = manager;
    }
    // Return the name of the album

    public String getName() {
        return this.albumName;
    }

    
	// Return the condition associated with the album
	public String getCondition() {
        return this.condition;
    }
    // Return the manager

    public PhotoManager getManager() {
        return manager;
    }
    // Return all photos that satisfy the album condition

    public LinkedList<Photo> getPhotos() {

        LinkedList<Photo> photos = new LinkedList<Photo>();
        BST<LinkedList<Photo>> myVar = manager.getPhotos();
        String Cond []= condition.split(" AND ");
        
        if (Cond[0].equals("")) {//empty condition 
            return manager.getlist();
        } else {
        	 if (!myVar.findKey(Cond[0]))
        		 return photos;
            for (int i = 0; i < Cond.length; i++) {//if condition not empty
                          
                    if (myVar.findKey(Cond[i])) {
                     
                        if (photos.empty()) {
                        	photos = myVar.retrieve();
                        } else {
                            
                            photos.findFirst();
                            while (!photos.last()) {
  
                                photos.retrieve().getTags().findFirst();
                                boolean check = false;

                                while (!photos.retrieve().getTags().last()) {

                                    //coding
                                    if (photos.retrieve().getTags().retrieve().equals(Cond[i])) {
                                        check = true;
                                        break;
                                    }

                                        photos.retrieve().getTags().findNext();

                                }
                                if (photos.retrieve().getTags().retrieve().equals(Cond[i])) {
                                    check = true;
                                    
                                }

                                 
                                
                                if (check == false) {
                                    photos.remove();
                                }
                                else
                                	photos.findNext();
              
                            }
                            photos.retrieve().getTags().findFirst();
                            boolean check = false;

                            while (!photos.retrieve().getTags().last()) {

                                
                                if (photos.retrieve().getTags().retrieve().equals(Cond[i])) {
                                    check = true;
                                    break;
                                }

                                
                                    photos.retrieve().getTags().findNext();
                                
                            }
                            if (photos.retrieve().getTags().retrieve().equals(Cond[i])) {
                                check = true;
                                
                            }
                            if (check == false) {
                                photos.remove();
                            }

                            
                        }

                    }
                    else {
                    	return new LinkedList<Photo>();
                    }

                }
            }
        

        return photos;
}
    // Return the number of tag comparisons used to find all photos of the album

    public int getNbComps() {
        
    	if (condition.equals(""))             
    		return 0;
    	String[] F = condition.split(" AND ");
    	int c = 0;
    	for (int i = 0; i < F.length; i++) { 
    		c += manager.getPhotos().NB(F[i]);         
    		}
    	return c;
    		}
 
    }

