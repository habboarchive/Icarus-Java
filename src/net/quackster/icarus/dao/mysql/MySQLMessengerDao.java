package net.quackster.icarus.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.quackster.icarus.dao.IMessengerDao;
import net.quackster.icarus.game.messenger.MessengerFriend;
import net.quackster.icarus.log.Log;
import net.quackster.icarus.mysql.Storage;

public class MySQLMessengerDao implements IMessengerDao {

	private MySQLDao dao;

	public MySQLMessengerDao(MySQLDao dao) {
		this.dao = dao;
	}

	@Override
	public List<MessengerFriend> getFriends(int userId) {
		
		List<MessengerFriend> friends = new ArrayList<MessengerFriend>();
		
		ResultSet row = null;
		
		try {
			
			row = dao.getStorage().getTable("SELECT * FROM messenger_friendships WHERE (sender = " + userId + ") OR (receiver = " + userId + ")");
			
			while (row.next()) {
				
				int friendId = 0;
				
				if (row.getInt("sender") != userId) {
					friendId = row.getInt("sender");
				}
				
				if (row.getInt("receiver") != userId) {
					friendId = row.getInt("receiver");
				}
				
				System.out.println("ID : " + friendId);
				
				friends.add(new MessengerFriend(friendId));
			}
			
		} catch (SQLException e) {
			Log.exception(e);
		}
		
		Storage.releaseObject(row);
		
		return friends;
	}

	public MySQLDao getDao() {
		return dao;
	}
}