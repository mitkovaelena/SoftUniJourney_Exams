using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class Program
    {
        static void Main(string[] args)
        {
            string month = Console.ReadLine();
            int days = int.Parse(Console.ReadLine());

            double studio = 0;
            double app = 0;

            switch (month)
            {
                case "May":
                case "October":
                    studio = days*50;
                    app = days*65;
                    if (days > 7 && days < 15) studio = studio - studio*0.05;
                    if (days > 14)
                    {
                        studio = studio - studio*0.3;
                        app = app - app*0.1;
                    }
                    break;
                case "June":
                case "September":
                    studio = days*75.20;
                    app = days*68.70;
                    if (days > 14)
                    {
                        studio = studio - studio*0.2;
                        app = app - app*0.1;
                    }
                    break;
                case "July":
                case "August":
                    studio = days*76;
                    app = days*77;
                    if (days > 14)
                    {
                        app = app - app*0.1;
                    }
                    break;
            }
      
        Console.WriteLine("Apartment: {0:F2} lv.", app);
        Console.WriteLine("Studio: {0:F2} lv.", studio);
        }
    }
}
