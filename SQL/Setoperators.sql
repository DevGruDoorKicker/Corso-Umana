--Set Operators

--Union
-- creo tabelle diverse con dati che si accodano. di solito si usano per partizionare dati i.e. prendo vendite per ogni anno e le accodo separandole
-- le colonne devono avere gli stessi tipi di dato e il numero di colonne deve essere uguale nelle select
select country, city,null from hr.Employees
union all
select country, city,null from Sales.Customers


--questa non ha duplicati (union distinct)
select country, city from hr.Employees
union 
select country, city from Sales.Customers

--Intersect (già distinct)
select country, city from hr.Employees
intersect
select country, city from Sales.Customers


--except (già distinct)
select country, city from hr.Employees
except
select country, city from Sales.Customers

--l'ordine conta ofc
select country, city from Sales.Customers
except
select country, city from hr.Employees


--Precedence(precedenza):
--Intersect
--Union, except

select country, city from hr.Employees
except
select country, city from Sales.Customers
intersect                                          --eseguo prima l'intersezione tra customers e suppliers per via dell'intersect
select country, city from Production.Suppliers


go
(select country, city from Sales.Customers
except                                         --con le parentesi ho forzato prima l'esecuzione dell'intersect
select country, city from hr.Employees
)intersect                                          
select country, city from Production.Suppliers


