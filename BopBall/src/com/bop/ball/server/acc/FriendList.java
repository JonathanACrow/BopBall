package com.bop.ball.server.acc;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FriendList
{
    @XmlAttribute
    private int id;
    @XmlElement
    private ArrayList<Integer> friends = new ArrayList<>(), reqs = new ArrayList<>();
    
    private FriendList()
    {}
    FriendList(int id)
    {
        this.id = id;
    }
    public void addFriend(int id)
    {
        if(!friends.contains(id)) friends.add(id);
    }
    public void removeFriend(int id)
    {
        friends.remove(id);
    }
    public void addFriendRequest(int id)
    {
        reqs.add(id);
    }
    public void removeFriendRequest(int id)
    {
        reqs.remove(id);
    }
    public Account getAccount()
    {
        return new Account(id);
    }
    public void save()
    {
        getAccount().saveFriends(this);
    }
    public void save(File file)
    {
        if(mar == null) initXml();
        try
        {
            mar.marshal(this, file);
        }
        catch(Exception error)
        {
            error.printStackTrace();
        }
    }
    
    private static Marshaller mar;
    private static Unmarshaller unmar;
    
    private static void initXml()
    {
        try
        {
            JAXBContext jaxb = JAXBContext.newInstance(FriendList.class);
            mar = jaxb.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            unmar = jaxb.createUnmarshaller();
        }
        catch(Exception error)
        {
            error.printStackTrace();
        }
    }
    public static FriendList load(File file)
    {
        if(unmar == null) initXml();
        try
        {
            return (FriendList)unmar.unmarshal(file);
        }
        catch(Exception error)
        {
            error.printStackTrace();
        }
        return null;
    }
}