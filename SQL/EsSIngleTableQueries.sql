


/*
1. Write a query against the Sales.Orders table that returns orders placed in April 2016.
Tables involved: Sales.Orders table
Output: orderid, orderdate, custid, empid
*/


SELECT orderid, orderdate, custid, empid 

FROM Sales.Orders

WHERE year(orderdate)= '2016' and month(orderdate) ='4'


/*
Write a query against the Sales.Orders table that returns orders placed on the last day of the month.
Tables involved: Sales.Orders table
Output: orderid, orderdate, custid, empid
Use EOMONTH function

*/

SELECT orderid, orderdate, custid, empid

FROM Sales.Orders

WHERE orderdate = EOMONTH(orderdate)


/*
3. Write a query against the HR.Employees table that returns employees with last name containing the
letter 'a' twice or more.
Tables involved: HR.Employees table
Output: empid, firstname, lastname

*/

SELECT empid, firstname, lastname


FROM HR.Employees

WHERE lastname like '%a%a%' 


/*

4. Write a query against the Sales.OrderDetails table 
that returns orders with total value (quantity * unitprice) greater than 10,000, sorted by total value.
Tables involved: Sales.OrderDetails table
Output: orderid, totalvalue

*/

SELECT sum(qty*unitprice) as totalvalue, orderid

FROM Sales.OrderDetails

group by orderid
Having sum(qty*unitprice)>10000

order by totalvalue desc


/*

5. Write a query against the Sales.Orders table that returns the three shipped-to countries with the highest average freight in 2016.
Tables involved: Sales.Orders table
Output: shipcountry, avgfreight


*/


SELECT top (3) with ties avg(freight) as avgfreight, shipcountry

FROM sales.orders

where year(orderdate)=2016

group by shipcountry

order by avgfreight desc

SELECT top (3) avg(freight) as avgfreight, shipcountry

FROM sales.orders

where year(orderdate)=2016

group by shipcountry

order by avgfreight desc



/*

Using the HR.Employees table, figure out the SELECT statement that returns for each employee the
gender based on the title of courtesy. For ‘Ms. ‘ and ‘Mrs.’ return ‘Female’; for ‘Mr. ‘ return ‘Male’; and in all other cases (for example, ‘Dr. ‘) return ‘Unknown’.
Tables involved: HR.Employees table
Output: empid, firstname, lastname, titleofcourtesy, gender


*/

SELECT empid, firstname, lastname, 
		case titleofcourtesy
			when 'Mr.' then 'male'         -- quando ho 1 nella colonna categoryid lo cambio a beverage
			when 'Ms.' then 'female'
			when 'Mrs.' then 'female'
			else 'unknown'
		end as gender

FROM hr.employees






/*

8. Write a query against the Sales.Customers table that returns for each customer the customer ID and
region. Sort the rows in the output by region, having NULL marks sort last (after non-NULL values).
Note that the default sort behavior for NULL marks in T-SQL is to sort first (before non-NULL values).
Tables involved: Sales.Customers table
Output: custid, region

*/

SELECT custid, region

FROM SALES.customers

order by region desc


SELECT custid, region

FROM SALES.customers

order by 
			case
				when region is null then 1
				else 0
			end, region;











