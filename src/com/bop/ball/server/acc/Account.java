package com.bop.ball.server.acc;

import java.io.File;

public class Account
{
    private static final String fileSep = File.separator;
    private int id;
    private File root, friends;
    
    public Account(int id)
    {
        this.id = id;
        root = new File("acc/" + id);
        friends = new File(root.getAbsolutePath() + fileSep + "friends.xml");
    }
    public int getID()
    {
        return id;
    }
    public void build()
    {
        if(!root.exists()) root.mkdirs();
        saveFriends(new FriendList(id));
    }
    public void saveFriends(FriendList list)
    {
        list.save(friends);
    }
}