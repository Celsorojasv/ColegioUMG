package com.umg.app.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.app.models.entity.Curso;
import com.umg.app.models.entity.Tareas;

@Service
public class TareasService implements ITareas {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	@Override
	public List<Tareas> findAllByCourse(Long id) {

		String sql = "SELECT t.id_tarea , t.punteo , c.nom_cu , c.id_curso FROM tareas t INNER JOIN cursos c  WHERE c.id_curso = ? ";

		return jdbcTemplate.query(sql, new Object[] { id }, new RowMapper<Tareas>() {
			@Override
			public Tareas mapRow(ResultSet rs, int rowNum) throws SQLException {
				Curso cu = new Curso();
				Tareas ta = new Tareas();

				ta.setIdTarea(rs.getLong("id_tarea"));
				ta.setPunteo(rs.getLong("punteo"));

				cu.setNombreCurso(rs.getString("nom_cu"));
				cu.setIdCurso(rs.getLong("id_curso"));

				ta.setCurso(cu);
				return ta;
			}
		}

		);
	}

	@Override
	public void save(Tareas tareas) {
		String sql = "INSERT INTO tareas " + "(id_tarea , punteo ,id_curso) " +
				"VALUES (?,?,?)";
		jdbcTemplate.update(sql, new Object[] {tareas.getIdTarea() , tareas.getPunteo() , tareas.getCurso().getIdCurso()});

	}

}
