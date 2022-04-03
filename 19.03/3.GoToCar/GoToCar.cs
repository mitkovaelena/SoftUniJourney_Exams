using System;


namespace GoToCar
{
    class GoToCar
    {
        static void Main()
        {
            double budget = double.Parse(Console.ReadLine());
            string season = Console.ReadLine();
            string carType = "";
            string carClass = "";
            double expences = 0;
                      
            if (budget <=100)
            {
              carClass = "Economy";
              if (season == "Summer")
              {
                expences = budget*0.35;
                carType = "Cabrio";  
              }
              else 
              {
                expences = budget*0.65;
                carType = "Jeep";
              }
            }
            else if (budget <= 500)
            {
                carClass = "Compact";
                if (season == "Summer")
                {
                exprnces = budget*0.45;
                carType = "Cabrio";
                }
                else 
                {
                expences = budget*0.8;
                carType = "Jeep";
                }
            }
            else 
            {
              carClass = "Luxury";
              expences = budget*0.9;
              carType = "Jeep";
            }
            Console.WriteLine("{0} class\n{1} - {2:0.00}", carClass, carType,expences);
        }
    }
}
