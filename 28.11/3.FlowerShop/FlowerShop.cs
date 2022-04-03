using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FlowerShop
{
    class Program
    {
        static void Main(string[] args)
        {

            int chrysanthems = int.Parse(Console.ReadLine());
            int roses = int.Parse(Console.ReadLine());
            int tulips = int.Parse(Console.ReadLine());

            string season = Console.ReadLine();
            string holiday = Console.ReadLine();

            double price = 0;

            switch (season)
            {
                case "Spring":
                    price = chrysanthems * 2 + roses * 4.1 + tulips * 2.5;
                    if (holiday == "Y") price *= 1.15;
                    if (tulips > 7) price *= 0.95;
                    break;
                case "Summer":
                    price = chrysanthems * 2 + roses * 4.1 + tulips * 2.5;
                    if (holiday == "Y") price *= 1.15;
                    break;
                case "Autumn":
                    price = chrysanthems * 3.75 + roses * 4.5 + tulips * 4.15;
                    if (holiday == "Y") price *= 1.15;
                    break;
                case "Winter":
                    price = chrysanthems * 3.75 + roses * 4.5 + tulips * 4.15;
                    if (holiday == "Y") price *= 1.15;
                    if (roses >= 10) price *= 0.90;
                    break;
            }
            if (chrysanthems + roses + tulips > 20) price *= 0.80;

            Console.WriteLine("{0:F2}", price + 2);
        }
    }
}
