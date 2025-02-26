class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == 0) return null;
        else{
            int output[] = new int[k];
            //buckets where index represent freq of elements contained in bucket
            List<Integer> freq_count[] = new ArrayList[nums.length+1];
            // key - element and value is frequency of key in list
            for(int i = 0;i<freq_count.length;i++) freq_count[i] = new ArrayList<>();
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i : nums){
                if(map.containsKey(i)) map.put(i,map.get(i)+1);
                else map.put(i,1);
            }
            //adding key to bucket at index[freq count i.e. key --> value]
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                freq_count[entry.getValue()].add(entry.getKey());
            }
            //iterating bucket list from last index to first till k times and popping 
            //element to output array
            for(int i = freq_count.length-1; i>0;i--){
                Iterator<Integer> iterator = freq_count[i].iterator();
                while(iterator.hasNext()){
                    output[--k] = iterator.next();
                    if(k == 0) break;
                }
                if(k == 0) break;
            }
            return output;
        }
    }
}
