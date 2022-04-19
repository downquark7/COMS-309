package backend.schedules;

import org.springframework.data.jpa.repository.JpaRepository;

/***
 * empty interface for the schedule jpa repository
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>
{
}
