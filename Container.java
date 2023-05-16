public class Container implements Comparable<Container> {
    // Declaring data fields to assign container attributes to it
    private String containerID;
    private String shortName;
    private String longName;

    // Mutators
    public String getContainerID() {
        return containerID;
    }

    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    // Override toString method to print the container
    @Override
    public String toString() {
        return  "      <CONTAINER "+ containerID + "\n" +
                "         <SHORT-NAME>"+shortName+"</SHORT-NAME>"+ "\n" +
                "         <LONG-NAME>"+longName+"</LONG-NAME>" +"\n" +
                "      </CONTAINER>\n";
    }

    // Override compareTo method to use sort method
    @Override
    public int compareTo(Container o) {
        if (this.getShortName().charAt(9) > o.getShortName().charAt(9)){
            return 1;
        }
        else if(this.getShortName().charAt(9) < o.getShortName().charAt(9)){
            return -1;
        }
        else{
            return 0;
        }
    }
}
