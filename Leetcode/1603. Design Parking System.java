//Amazon 12
class ParkingSystem {

    private Map<String, Integer> map = null;
    private int big_= 0 ;
    private int medium_ = 0;
    private int small_ = 0;
    public ParkingSystem(int big, int medium, int small) {
        map = new HashMap<>();
        big_ = big;
        medium_= medium;
        small_ = small;
        map.put("big", map.getOrDefault("big", 0) + big_);
        map.put("medium", map.getOrDefault("medium", 0) + medium_);
        map.put("small", map.getOrDefault("small", 0) + small_);
    }
    
    public boolean addCar(int carType) {
        boolean isPresent = false;
        if(carType == 1)
        {
            if(map.get("big") > 0)
            {
                isPresent = true;
                map.put("big", map.get("big") - 1);
            }
        }
        else if(carType == 2)
        {
            if(map.get("medium") > 0)
            {
                isPresent = true;
                map.put("medium", map.get("medium") - 1);
            }
        }
        else
        {
            if(map.get("small") > 0)
            {
                isPresent = true;
                map.put("small", map.get("small") - 1);
            }   
        }
        return isPresent;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

 //optimal
 class ParkingSystem {
    private int[] count;
    public ParkingSystem(int big, int medium, int small) {
        count = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        boolean isPresent = false;  // else directly return count[carType - 1]-- > 0;
        if(count[carType - 1] > 0)
        {
            isPresent = true;
            count[carType - 1]--;
        }
        return isPresent;
    }
}