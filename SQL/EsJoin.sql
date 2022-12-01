/*
1. Write a query that generates five copies of each employee row.
Tables involved: HR.Employees and dbo.Nums
Output: empid, firstname, lastname, n
*/

SELECT e.empid, e.firstname, e.lastname, n.n

FROM HR.Employees as e

cross join dbo.Nums as n

where n.n<=5

order by e.empid

/*
2. Return United States customers, and for each customer return the total number of orders and total quantities.
Tables involved: Sales.Customers, Sales.Orders, and Sales.OrderDetails
Output: custid, numorders, totalqty

*/
--tentativo a metà
SELECT o.custid,
	sum(freight) as totalqty,
	count(o.custid) as numorders

FROM SALES.CUSTOMERS AS C

JOIN sales.orders as o

ON C.CUSTID=o.custid

 where c.country = 'USA'

 group by o.custid





SELECT o.custid,
	sum(od.qty) as totalqty,
	count(distinct o.orderid) as numorders
FROM SALES.CUSTOMERS AS C
JOIN sales.orders as o
ON C.CUSTID=o.custid
JOIN sales.orderdetails as od
ON od.orderid=o.orderid
 where c.country = 'USA'
 group by o.custid
 order by numorders desc



	
/*
3. Return customers and their orders, including customers who placed no orders.
Tables involved: Sales.Customers and Sales.Orders
Output: custid, companyname, orderid, orderdate

*/

SELECT o.orderid, c.companyname, o.orderdate, c.custid

FROM SALES.CUSTOMERS AS C

left outer JOIN sales.orders as o

ON C.CUSTID=o.custid


/*
4. Return customers who placed no orders.
Tables involved: Sales.Customers and Sales.Orders
Output: custid, companyname

*/

SELECT o.orderid, c.companyname, o.orderdate, c.custid

FROM SALES.CUSTOMERS AS C

left outer JOIN sales.orders as o

ON C.CUSTID=o.custid

where orderid is null


/*
5. Return customers with orders placed on February 12, 2016, along with their orders.
Tables involved: Sales.Customers and Sales.Orders
Output: custid, companyname, orderid, orderdate

*/

SELECT o.orderid, c.companyname, o.orderdate, c.custid

FROM SALES.CUSTOMERS AS C

JOIN sales.orders as o

ON C.CUSTID=o.custid

where YEAR(o.orderdate) ='2016' and MONTH (o.orderdate) = 2 and day(o.orderdate) =12


/*
6. Return customers with orders placed on February 12, 2016, along with their orders. Also return customers who didn’t place orders on February 12, 2016.
Tables involved: Sales.Customers and Sales.Orders
Output: custid, companyname, orderid, orderdate
*/

SELECT o.orderid, c.companyname, o.orderdate, c.custid

FROM SALES.CUSTOMERS AS C

left outer JOIN sales.orders as o

ON C.CUSTID=o.custid

where orderdate is not null


/*
7. Return all customers, and for each return a Yes/No value depending on whether the customer placed
an order on February 12, 2016.
Tables involved: Sales.Customers and Sales.Orders
Output: custid, companyname, HasOrderOn20160212
*/


--tentativo non corretto ma quasi
SELECT  c.companyname,  c.custid, o.orderid,o.orderdate,
			case 
					when  YEAR(o.orderdate) ='2016' and MONTH (o.orderdate) = 2 and day(o.orderdate) =12 then 'yes' 
					else 'no'		
			end  as HasOrderOn20160212
FROM Sales.Customers AS C
left outer JOIN sales.orders as o
ON C.CUSTID=o.custid

order by c.custid desc



--es giusto

SELECT  c.companyname,  c.custid, o.orderid,o.orderdate,

			case 
					when  o.orderid is not null then 'yes'
					else 'no'		
			end  as HasOrderOn20160212

FROM Sales.Customers AS C

left outer JOIN sales.orders as o

ON C.CUSTID=o.custid and o.orderdate='20160212'

order by HasOrderOn20160212 desc