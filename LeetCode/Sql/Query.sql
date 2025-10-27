select column1,column2,count(*) AS count
from your_table
group by column1,column2
having count(*) >1

select e.name,d.department_name
from employee e
INNER JOIN departments d on e.department_id = d.department_id;

select e.name,d.department_name
from employee e
LEFT JOIN departments d on e.department_id = d.department_id
LEFT JOIN analysis p on e.analysis_id = p.analysis_id

select e.name,d.department_name
from employee e
OUTER JOIN departments d on e.department_id = d.department_id;

select distinct salary
from employees
order by salary DESC
LIMIT 1 offset 1;