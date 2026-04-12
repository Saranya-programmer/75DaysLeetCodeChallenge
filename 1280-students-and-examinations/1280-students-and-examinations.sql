# Write your MySQL query statement below
select stu.student_id,stu.student_name,s.subject_name,count(e.subject_name) as attended_exams
from Students stu
cross join Subjects s
left join Examinations e
on stu.student_id=e.student_id
and  s.subject_name=e.subject_name
group by
stu.student_id,stu.student_name,s.subject_name
order by stu.student_id,s.subject_name;