using System;
using System.Collections.Generic;
using System.Linq;
using System.Data;

namespace TouristWebAPI
{
    public interface IServiceAPI
    {
        void CreateNewAccount(string firstName, string lastName, string userName, string password, string phoneNumber);
        DataTable GetUserDetails(string userName);
        void UpdateUserDetails(string firstName, string lastName, string userName, string password, string phoneNumber);
        bool UserAuthentication(string userName, string passsword);
        DataTable GetRouteDetails(string startPoint, string date);
        void CreateNewRoute(string startPoint, string endPoint, string date, string time, string ownerName, string phoneNumber );

    }
}