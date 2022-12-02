
/*1.
Run the following code to create the dbo.Customers table.

IF OBJECT_ID('dbo.Customers', 'U') IS NOT NULL DROP TABLE dbo.Customers;

CREATE TABLE dbo.Customers
(
custid INT NOT NULL PRIMARY KEY,
companyname NVARCHAR(40) NOT NULL,
country NVARCHAR(15) NOT NULL,
region NVARCHAR(15) NULL,
city NVARCHAR(15) NOT NULL
);

1-1. Insert into the dbo.Customers table a row with:
 custid: 100
 companyname: Coho Winery
 country: USA
 region: WA
 city: Redmond

1-2. Insert into the dbo.Customers table all customers from Sales.Customers who placed orders.
Check if you have to truncate.

1-3. Use a insert select statement to create and populate the dbo.Orders table with orders from the
Sales.Orders table that were placed in the years 2014 through 2016.

2. Delete from the dbo.Orders table orders that were placed before August 2014. Use the OUTPUT
clause to return the orderid and orderdate of the deleted orders.
Output: orderid, orderdate

3. Delete from the dbo.Orders table orders placed by customers from Brazil.

4. Run the following query against dbo.Customers, and notice that some rows have a NULL in the region
column.

SELECT * FROM dbo.Customers;

Update the dbo.Customers table and change all NULL region values to <None>. Use the OUTPUT
clause to show the custid, oldregion, and newregion.

Output: custid, oldregion, newregion

5. Update all orders in the dbo.Orders table that were placed by United Kingdom customers and set
their shipcountry, shipregion, and shipcity values to the country, region, and city values of the corresponding customers.

6. When you’re done, run the following code for cleanup.

IF OBJECT_ID('dbo.Orders', 'U') IS NOT NULL DROP TABLE dbo.Orders;
IF OBJECT_ID('dbo.Customers', 'U') IS NOT NULL DROP TABLE dbo.Customers;
*/

--1
IF OBJECT_ID('dbo.Customers', 'U') IS NOT NULL DROP TABLE dbo.Customers;

CREATE TABLE dbo.Customers
(
custid INT NOT NULL PRIMARY KEY,
companyname NVARCHAR(40) NOT NULL,
country NVARCHAR(15) NOT NULL,
region NVARCHAR(15) NULL,
city NVARCHAR(15) NOT NULL
);

--1.1
/*
1-1. Insert into the dbo.Customers table a row with:
 custid: 100
 companyname: Coho Winery
 country: USA
 region: WA
 city: Redmond
*/

insert into dbo.Customers values ( 100, 'Coho Winery',
  'USA',
  'WA',
  'Redmond')

  /*1-2. Insert into the dbo.Customers table all customers from Sales.Customers who placed orders.
Check if you have to truncate.*/

select * from dbo.Customers
select * from Sales.Orders
go
insert into dbo.Customers 
select custid, companyname, country, region, city from Sales.Customers as c 
where exists
(select custid from Sales.Orders as o where c.custid=o.custid)

select * from Sales.Customers
select * from Sales.Orders
/*1-3. Use a insert select statement to create and populate the dbo.Orders table with orders from the
Sales.Orders table that were placed in the years 2014 through 2016.*/



CREATE TABLE [dbo].[Orders](
	[orderid] [int]  NOT NULL,
	[custid] [int] NULL,
	[empid] [int] NOT NULL,
	[orderdate] [date] NOT NULL,
	[requireddate] [date] NOT NULL,
	[shippeddate] [date] NULL,
	[shipperid] [int] NOT NULL,
	[freight] [money] NOT NULL,
	[shipname] [nvarchar](40) NOT NULL,
	[shipaddress] [nvarchar](60) NOT NULL,
	[shipcity] [nvarchar](15) NOT NULL,
	[shipregion] [nvarchar](15) NULL,
	[shippostalcode] [nvarchar](10) NULL,
	[shipcountry] [nvarchar](15) NOT NULL,
 CONSTRAINT [PK_Orders1] PRIMARY KEY CLUSTERED 
(
	[orderid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO 

drop table dbo.Orders

go
insert into dbo.Orders
select * from Sales.orders as c where orderid is not null


/*2. Delete from the dbo.Orders table orders that were placed before August 2014. Use the OUTPUT
clause to return the orderid and orderdate of the deleted orders.
Output: orderid, orderdate*/
go
select * from dbo.orders

go
delete from  dbo.Orders      
output deleted.orderid as oldID, deleted.orderdate as oldDAte
where orderdate<'20140801'


/*3. Delete from the dbo.Orders table orders placed by customers from Brazil.*/


delete from o                           
from dbo.orders as o
inner join Sales.Customers as c
on c.custid=o.custid
where c.country='Brazil'



/*4. Run the following query against dbo.Customers, and notice that some rows have a NULL in the region
column.

SELECT * FROM dbo.Customers;

Update the dbo.Customers table and change all NULL region values to <None>. Use the OUTPUT
clause to show the custid, oldregion, and newregion.

Output: custid, oldregion, newregion*/

update dbo.Customers 
	set region='None'
output inserted.custid, inserted.region as newregion, deleted.region as oldregion
where region is null

SELECT * FROM dbo.Customers


/*5. Update all orders in the dbo.Orders table that were placed by United Kingdom customers and set
their shipcountry, shipregion, and shipcity values to the country, region, and city values of the corresponding customers.*/

go
update dbo.orders
	set shipcountry=o.country, shipregion=o.region, shipcity=o.city
from dbo.orders as od 
join dbo.Customers as o
on od.custid=o.custid
where o.country ='UK'

select * from dbo.orders
select * from dbo.Customers
order by shipregion desc










