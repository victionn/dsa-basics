class Twitter {
    public HashMap<Integer, List<int[]>> tweets;
    public HashMap<Integer, Set<Integer>> followers;
    public int count = 0;
    public Twitter() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        //make heap, heap should be a min heap on index
        //when making a valid pop, if index 
        // need (pos, index, followeeid, tweetid)
        //heap map sorted on pos, index to find where the tweet location is
        followers.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for (int fol : followers.get(userId)) {
            if (tweets.containsKey(fol)) {
                List<int[]> curr = tweets.get(fol);
                int[] last = curr.get(curr.size() - 1);
                pq.offer(new int[]{last[0], curr.size() - 1, fol, last[1]});
            }
        }
        List<Integer> ret = new ArrayList<>();
        while (!pq.isEmpty() && ret.size() < 10) {
            int[] top = pq.poll();
            ret.add(top[3]);
            int index = top[1] - 1;
            if (index >= 0) {
                int[] newTweet = tweets.get(top[2]).get(index);
                pq.offer(new int[]{newTweet[0], index, top[2], newTweet[1]});
            }
        }
        return ret;

    }
    
    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}
