package guang.crawler.connector;

import guang.crawler.core.DataPacket;
import guang.crawler.util.StreamHelper;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author yang
 */
public class SiteManagerConnector
{
	
	private Socket	socket;
	
	public SiteManagerConnector(String host, int port)
	        throws UnknownHostException, IOException
	{
		this.socket = new Socket(host, port);
		
	}
	
	public DataPacket read() throws IOException
	{
		return StreamHelper.readObject(this.socket.getInputStream(),
		        DataPacket.class);
	}
	
	public void send(DataPacket packet) throws IOException
	{
		StreamHelper.writeObject(this.socket.getOutputStream(), packet);
	}
	
	public void shutdown() throws IOException
	{
		if (this.socket != null)
		{
			this.socket.close();
		}
	}
	
}
