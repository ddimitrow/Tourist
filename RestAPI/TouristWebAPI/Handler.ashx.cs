using JsonServices;
using JsonServices.Web;

namespace TouristWebAPI
{
    public class Handler : JsonHandler
    {
        public Handler()
        {
            this.service.Name = "TouristWebAPI";
            this.service.Description = "JSON API for android tourist appliation";
            InterfaceConfiguration IConfig = new InterfaceConfiguration("RestAPI", typeof(IServiceAPI), typeof(ServiceAPI));
            this.service.Interfaces.Add(IConfig);
        }

    }
}