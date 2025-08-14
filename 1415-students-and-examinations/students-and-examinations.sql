# Write your MySQL query statement below
select st.student_id,
st.student_name,
su.subject_name,
count(e.subject_name) as attended_exams
from students as st
cross join subjects as su    
left join examinations as e
on st.student_id = e.student_id
and e.subject_name = su.subject_name
group by st.student_id,st.student_name,su.subject_name
ORDER BY
  st.student_id, su.subject_name;
