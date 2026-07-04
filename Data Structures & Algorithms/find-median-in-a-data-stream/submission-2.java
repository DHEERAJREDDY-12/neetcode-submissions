class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    int c=0;
    public MedianFinder() {
        min=new PriorityQueue<>();
        max=new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        if(max.size()==0){
            max.offer(num);
        }
        else if(max.peek()>=num){
            max.offer(num);
            
            if(max.size()-min.size()>1){
                min.offer(max.poll());
            }
        }
        else{
            min.offer(num);
            if(min.size()-max.size()>1){
                max.offer(min.poll());
            }
        }
        c++;
        System.out.println(c);
    }
    
    public double findMedian() {
        if(c==1){
            return (double) max.peek();
        }
        if(c%2==0){
            double a=(double) min.peek();
            double b=(double) max.peek();
            return (a+b)/2;
        }
        else{
            if(max.size()>min.size()){
                return max.peek();
            }
            else{
                return min.peek();
            }
        }
    }
}
