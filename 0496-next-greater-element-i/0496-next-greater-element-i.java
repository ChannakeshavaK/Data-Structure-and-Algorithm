class Solution
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        Stack<Integer> mStack=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--)
        {
            int num=nums2[i];
            while(!mStack.empty() && mStack.peek() <=num)
            {
                mStack.pop();
            }
            if(mStack.empty())
            {
                map.put(num,-1);
            }
            else
            {
                map.put(num,mStack.peek());
            }
            mStack.push(num);
        }
        for(int i=0;i<nums1.length;i++)
        {
            nums1[i] = map.containsKey(nums1[i] )? map.get(nums1[i]) :-1;
        }
        return nums1;
    }
}