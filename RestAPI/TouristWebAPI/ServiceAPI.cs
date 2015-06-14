using System;
using System.Data;
using System.Data.SqlClient;

namespace TouristWebAPI
{
    public class ServiceAPI : IServiceAPI
    {
        SqlConnection dbConnection;

        public ServiceAPI()
        {
            dbConnection = DBConnect.getConnection();
        }

        public void CreateNewAccount(string firstName, string lastName, string userName, string password, string phoneNumber)
        {
            if (dbConnection.State.ToString() == "Closed")
            {
                dbConnection.Open();
            }

            string query = "INSERT INTO UserDetails VALUES ('" + firstName + "','" + lastName + "','" + userName + "','" + password + "','" + phoneNumber + "');";

            SqlCommand command = new SqlCommand(query, dbConnection);
            command.ExecuteNonQuery();

            dbConnection.Close();
        }

        public DataTable GetUserDetails(string userName)
        {
            DataTable userDetailsTable = new DataTable();
            userDetailsTable.Columns.Add(new DataColumn("firstName", typeof(String)));
            userDetailsTable.Columns.Add(new DataColumn("lastName", typeof(String)));
            userDetailsTable.Columns.Add(new DataColumn("phoneNumber", typeof(String)));

            if (dbConnection.State.ToString() == "Closed")
            {
                dbConnection.Open();
            }

            string query = "SELECT firstName,lastName,phoneNumber FROM UserDetails WHERE userName='" + userName + "';";

            SqlCommand command = new SqlCommand(query, dbConnection);
            SqlDataReader reader = command.ExecuteReader();

            if (reader.HasRows)
            {
                while (reader.Read())
                {
                    userDetailsTable.Rows.Add(reader["firstName"], reader["lastName"], reader["phoneNumber"]);
                }
            }

            reader.Close();
            dbConnection.Close();
            return userDetailsTable;

        }

        public void UpdateUserDetails(string firstName, string lastName, string userName, string password, string phoneNumber)
        {
            {
                if (dbConnection.State.ToString() == "Closed")
                {
                    dbConnection.Open();
                }
                string query = "UPDATE UserDetails SET firstName='" + firstName + "',"+"lastName='" + lastName + "'," +"phoneNumber='"+ phoneNumber+"'" + "WHERE userName='" + userName + "';";
          //    string query = "INSERT INTO UserDetails VALUES ('" + firstName + "','" + lastName + "','" + userName + "','" + password + "','" + phoneNumber + "');";

                SqlCommand command = new SqlCommand(query, dbConnection);
                command.ExecuteNonQuery();

                dbConnection.Close();
            }
        }

        public bool UserAuthentication(string userName, string passsword)
        {
            bool auth = false;

            if (dbConnection.State.ToString() == "Closed")
            {
                dbConnection.Open();
            }

            string query = "SELECT id FROM UserDetails WHERE userName='" + userName + "' AND password='" + passsword + "';";

            SqlCommand command = new SqlCommand(query, dbConnection);
            SqlDataReader reader = command.ExecuteReader();

            if (reader.HasRows)
            {
                auth = true;
            }

            reader.Close();
            dbConnection.Close();

            return auth;

        }

        public DataTable GetRouteDetails(string startPoint, string date)
        {
            DataTable routeTable = new DataTable();
            routeTable.Columns.Add("startPoint", typeof(String));
            routeTable.Columns.Add("endPoint", typeof(String));
            routeTable.Columns.Add("date", typeof(String));
            routeTable.Columns.Add("time", typeof(String));
            routeTable.Columns.Add("ownerName", typeof(String));
            routeTable.Columns.Add("phoneNumber", typeof(String));

            if (dbConnection.State.ToString() == "Closed")
            {
                dbConnection.Open();
            }

            string query =  "SELECT startPoint,endPoint,date,time,ownerName,phoneNumber FROM Route WHERE startPoint='" + startPoint + "' and date='" + date + "';";
            SqlCommand command = new SqlCommand(query, dbConnection);
            SqlDataReader reader = command.ExecuteReader();

            if (reader.HasRows)
            {
                while (reader.Read())
                {
                    routeTable.Rows.Add(reader["startPoint"], reader["endPoint"], reader["date"], reader["time"], reader["ownerName"], reader["phoneNumber"]);
                }
            }

            reader.Close();
            dbConnection.Close();

            return routeTable;
        }
        public void CreateNewRoute(string startPoint, string endPoint, string date, string time, string ownerName, string phoneNumber)
        {
            if (dbConnection.State.ToString() == "Closed")
            {
                dbConnection.Open();
            }

            string query = "INSERT INTO Route VALUES ('" + startPoint + "','" + endPoint + "','" + date + "','" + time + "','" + ownerName + "','" + phoneNumber + "');";

            SqlCommand command = new SqlCommand(query, dbConnection);
            command.ExecuteNonQuery();

            dbConnection.Close();
        }

    }
}