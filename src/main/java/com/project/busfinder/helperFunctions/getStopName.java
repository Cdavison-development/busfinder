package com.project.busfinder.helperFunctions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.project.busfinder.helperFunctions.makeConnection.conn;

public class getStopName {

    public static String StopName(String stopId) throws SQLException {
        String query = "SELECT common_name FROM bus_stops WHERE stop_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, stopId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("common_name");
            }
        }
        return "Unknown Stop";
    }
}
