/*1. Write a query that returns all orders placed on the last day of activity that can be found in the
Orders table.
Tables involved: Sales.Orders
Output: orderid, orderdate, custid, empid
*/


select orderid, orderdate, custid, empid from Sales.Orders as o1
where o1.orderdate=
(select max(o2.orderdate) from Sales.Orders as o2)                 --non è correlata perché può essere risolta indipendentemente


/*s2. Write a query that returns all orders placed by the customer(s) who placed the highest number of
orders. Note that more than one customer might have the same number of orders.
Tables involved: Sales.Orders
Output: custid, orderid, orderdate, empid
*/



select custid, orderid, orderdate, empid from Sales.orders as o1
where o1.custid in (select top (1) with ties o2.custid from Sales.Orders as o2 group by o2.custid order by count(*) desc)


/*3. Write a query that returns employees who did not place orders on or after May 1, 2016.
Tables involved: HR.Employees and Sales.Orders
Output: empid, FirstName, lastname
*/

select * from HR.Employees
select * from sales.orders

-- metodo computazionalmente non corretto
select empid, FirstName, lastname from HR.Employees as e
where e.empid not in
(select e.empid from Sales.orders as o where orderdate  >= '20160501' and o.empid=e.empid )


-- metodo corretto
select empid, FirstName, lastname from hr.Employees
where empid not in

(select empid from Sales.orders 
where orderdate>='20160501')



/*4. Write a query that returns countries where there are customers but not employees.
Tables involved: Sales.Customers and HR.Employees
Output: country

*/

select distinct country
from sales.Customers
where country not in 
(select country from hr.Employees) 


/*5. Write a query that returns for each customer all orders placed on the customer’s last day of activity.
Tables involved: Sales.Orders
Output: custid, orderid, orderdate, empid
*/










/*6. Write a query that returns customers who placed orders in 2015 but not in 2016.
Tables involved: Sales.Customers and Sales.Orders
Output: custid, companyname
*/







/*6. Write a query that returns customers who placed orders in 2015 but not in 2016.
Tables involved: Sales.Customers and Sales.Orders
Output: custid, companyname
*/









/*7. Write a query that returns customers who ordered product 12.
Tables involved: Sales.Customers, Sales.Orders, and Sales.OrderDetails
Output: custid, companyname
*/

-- funziona ma poco efficiente sull'ultimo ciclo
select custid, companyname from Sales.Customers
where custid in 
(select custid from Sales.Orders
where orderid in (select od.orderid from Sales.OrderDetails as od where od.productid=12)) 


--funziona ed è più efficiente per l'exists
select custid, companyname from Sales.Customers as c
where exists 
(select custid from Sales.Orders as o where c.custid=o.custid and exists
(select od.orderid from Sales.OrderDetails as od where od.productid=12 and od.orderid=o.orderid))     --exists è rapido perché basta un valore che rende vera l'exists perché sei fermi












/*8. Write a query that calculates a running-total quantity for each customer and month.
Tables involved: Sales.CustOrders
Output: custid, ordermonth, qty, runqty
*/




































