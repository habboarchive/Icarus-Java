package net.quackster.icarus.dao.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.quackster.icarus.Icarus;
import net.quackster.icarus.game.user.CharacterDetails;
import net.quackster.icarus.game.user.Session;
import net.quackster.icarus.log.Log;
import net.quackster.icarus.mysql.Storage;

public class PlayerDao {

	public static CharacterDetails getDetails(int userId) {
		
		try {
			
			PreparedStatement statement = Icarus.getStorage().prepare("SELECT * FROM users WHERE user_id = ? LIMIT 1");
			statement.setInt(1, userId);

			ResultSet row = statement.executeQuery();
			
			CharacterDetails details = new CharacterDetails();
			
			if (!row.next()) {
				return null;
			}

			details.fill(row);
			details.setAuthenticated(true);
			
			Storage.releaseObject(row);
			
			return details;
			
		} catch (SQLException e) {
			Log.exception(e);
		}
		
		return null;
	}
	
	public static boolean login(Session session, String ssoTicket) {
		
		try {
			
			PreparedStatement statement = Icarus.getStorage().prepare("SELECT * FROM users WHERE sso_ticket = ? LIMIT 1");
			statement.setString(1, ssoTicket);

			ResultSet row = statement.executeQuery();
			
			if (!row.next()) {
				return false;
			}
			
			session.getDetails().fill(row);
			
			Storage.releaseObject(row);
			
			return true;
			
		} catch (SQLException e) {
			Log.exception(e);
		}
		
		return false;
	}
	
}
