package com.umg.app.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.app.models.entity.AsignacionEst;
import com.umg.app.models.entity.Curso;
import com.umg.app.models.entity.Estudiante;

@Service
public class AsignacionEstService implements IAsignacionEst {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly = true)
	@Override
	public List<AsignacionEst> findAll() {

		String sql = "SELECT e.id_estudiante, e.nom_es1, e.ape_es1, c.nom_cu , c.horario , ass.id_asignacion_estu FROM asignacion_estu ass " + 
				" INNER JOIN estudiantes e ON ass.id_estudiante = e.id_estudiante " + 
				" INNER JOIN cursos c ON ass.id_curso = c.id_curso";
	
		return jdbcTemplate.query(sql, new RowMapper<AsignacionEst>() {

			@Override
			public AsignacionEst mapRow(ResultSet rs, int rowNum) throws SQLException {
				AsignacionEst asignacion = new AsignacionEst();
				Estudiante es = new Estudiante();
				Curso cu = new Curso();
				
			
				es.setNombreEstu1(rs.getString("nom_es1"));
				es.setApeEstu1(rs.getString("ape_es1"));
				cu.setNombreCurso(rs.getString("nom_cu"));
				cu.setHorarioCurso(rs.getNString("horario"));
				
				asignacion.setCurso(cu);
				asignacion.setEstudiante(es);
				asignacion.setIdAsignacion(rs.getInt("id_asignacion_estu"));
				
				return asignacion;
			}
		});
	}

	@Override
	@Transactional
	public void save(AsignacionEst AsignacionEst) {
		String sql =  "INSERT INTO asignacion_estu" + "(id_estudiante,id_curso) VALUES (?,?)";
		jdbcTemplate.update(sql, new Object[] {AsignacionEst.getEstudiante().getIdEstu() , AsignacionEst.getCurso().getIdCurso()});	
	}

	
	@Override
	@Transactional(readOnly = true)
	public AsignacionEst findOne(long id) {

		String sql = "SELECT e.id_estudiante, e.nom_es1, e.ape_es1, c.nom_cu c.horario FROM asignaciones_estudiantes ass " + 
				" INNER JOIN estudiantes e ON ass.id_estudiante = e.id_estudiante " + 
				" INNER JOIN cursos c ON ass.id_curso = c.id_curso WHERE id_asignacion_estudiante = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<AsignacionEst>() {

			@Override
			public AsignacionEst mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				AsignacionEst asignacion = new AsignacionEst();
				Estudiante es = new Estudiante();
				Curso cu = new Curso();
				
				es.setNombreEstu1(rs.getString("nom_es1"));
				es.setApeEstu1(rs.getString("ape_es1"));
				cu.setNombreCurso(rs.getString("nom_cu"));
				cu.setHorarioCurso(rs.getNString("horario"));
				
				asignacion.setCurso(cu);
				asignacion.setEstudiante(es);
				
				return asignacion;
			}
		});
	
		
	}

	
	@Override
	@Transactional
	public void delete(long id) {

		String sql = "DELETE FROM asignacion_estu WHERE id_asignacion_estu = ?";
		jdbcTemplate.update(sql, new Object[] {id});
	}

	@Override
	public List<AsignacionEst> findAllByStudent(Long id) {
		String sql = "SELECT e.id_estudiante, e.nom_es1, e.ape_es1, c.nom_cu , c.horario , ass.id_asignacion_estu FROM asignacion_estu ass " + 
				" INNER JOIN estudiantes e ON ass.id_estudiante = e.id_estudiante " + 
				" INNER JOIN cursos c ON ass.id_curso = c.id_curso WHERE e.id_estudiante = ?";
	
		return jdbcTemplate.query(sql, new Object[] {id} ,  new RowMapper<AsignacionEst>() {

			@Override
			public AsignacionEst mapRow(ResultSet rs, int rowNum) throws SQLException {
				AsignacionEst asignacion = new AsignacionEst();
				Estudiante es = new Estudiante();
				Curso cu = new Curso();
				
			    es.setIdEstu(rs.getLong("id_estudiante"));
				es.setNombreEstu1(rs.getString("nom_es1"));
				es.setApeEstu1(rs.getString("ape_es1"));
				cu.setNombreCurso(rs.getString("nom_cu"));
				cu.setHorarioCurso(rs.getNString("horario"));
				
				asignacion.setCurso(cu);
				asignacion.setEstudiante(es);
				asignacion.setIdAsignacion(rs.getInt("id_asignacion_estu"));
				
				return asignacion;
			}
		});
	}

	@Transactional(readOnly = true)
	@Override
	public List<AsignacionEst> findAllByCourse(Long id) {
	
			String sql = "SELECT e.id_estudiante, e.nom_es1, e.ape_es1, c.horario,  ass.id_asignacion_estu FROM asignacion_estu ass " + 
					" INNER JOIN estudiantes e ON ass.id_estudiante = e.id_estudiante " + 
					" INNER JOIN cursos c ON ass.id_curso = c.id_curso WHERE c.id_curso = ?";
		
			return jdbcTemplate.query(sql,  new Object[] {id} , new RowMapper<AsignacionEst>() {

				@Override
				public AsignacionEst mapRow(ResultSet rs, int rowNum) throws SQLException {
					AsignacionEst asignacion = new AsignacionEst();
					Estudiante es = new Estudiante();
					Curso cu = new Curso();
					
					es.setIdEstu(rs.getLong("id_estudiante"));
					es.setNombreEstu1(rs.getString("nom_es1"));
					es.setApeEstu1(rs.getString("ape_es1"));
					cu.setHorarioCurso(rs.getNString("horario"));
					
					asignacion.setCurso(cu);
					asignacion.setEstudiante(es);
					asignacion.setIdAsignacion(rs.getInt("id_asignacion_estu"));
					
					return asignacion;
				}
			});
		
	}
	
}
