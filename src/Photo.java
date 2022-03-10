
public class Photo {
        String path;
        LinkedList<String> tag;
        
	// Constructor
	public Photo(String path, LinkedList<String> tags){
            this.path = path;
            this.tag = tags;
            
        }
	// Return the path (full file name) of the photo. A photo is uniquely identified by its path.
	public String getPath(){
            return path;
        }
	// Return all tags associated with the photo
	public LinkedList<String> getTags(){
            return tag;
        }
        
        public String toString(){
            
            String temp = this.getPath()+":\t";
            this.tag.findFirst();
            while(this.tag.retrieve()!=null){
                
                temp += this.tag.retrieve()+"  ";
                if (this.tag.last()) {
                    break;
                    
                }
                else{
                    this.tag.findNext();
                }
                
            }
            
            
            return temp;
        }
}

