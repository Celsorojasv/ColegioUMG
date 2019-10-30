package com.umg.app.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.app.models.entity.AsignacionMae;
import com.umg.app.models.entity.Curso;
import com.umg.app.models.entity.Maestro;

@Service
public class AsignacionMaeService implements IAsignacionMae {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly = true)
	@Override
	public List<AsignacionMae> findAll() {

		String sql = "SELECT m.id_maestro, m.nom_ma1, m.ape_ma1, c.nom_cu , c.horario , ass.id_asignacion_ma FROM asignacion_ma ass " + 
				" INNER JOIN maestros m ON ass.id_maestro = m.id_maestro " + 
				" INNER JOIN cursos c ON ass.id_curso = c.id_curso";
	
		return jdbcTemplate.query(sql, new RowMapper<AsignacionMae>() {

			@Override
			public AsignacionMae mapRow(ResultSet rs, int rowNum) throws SQLException {
				AsignacionMae asignacion = new AsignacionMae();
				Maestro ma = new Maestro();
				Curso cu = new Curso();
				
			
				ma.setNombreMa1(rs.getString("nom_ma1"));
				ma.setApellidoMa1(rs.getString("ape_ma1"));
				cu.setNombreCurso(rs.getString("nom_cu"));
				cu.setHorarioCurso(rs.getNString("horario"));
				
				asignacion.setCurso(cu);
				asignacion.setMaestro(ma);
				asignacion.setIdAsignacion(rs.getInt("id_asignacion_ma"));
				
				return asignacion;
			}
		});
	}

	@Transactional(readOnly = true)
	@Override
	public List<AsignacionMae> findAllByTeacher(Long id) {
		String sql = "SELECT m.id_maestro, m.nom_ma1, m.ape_ma1, c.nom_cu , c.horario , ass.id_asignacion_ma FROM asignacion_ma ass " + 
				" INNER JOIN maestros m ON ass.id_maestro = m.id_maestro " + 
				" INNER JOIN cursos c ON ass.id_curso = c.id_curso WHERE m.id_maestro = ?";
	
		return jdbcTemplate.query(sql,  new Object[] {id} , new RowMapper<AsignacionMae>() {

			@Override
			public AsignacionMae mapRow(ResultSet rs, int rowNum) throws SQLException {
				AsignacionMae asignacion = new AsignacionMae();
				Maestro ma = new Maestro();
				Curso cu = new Curso();
				
			
				ma.setNombreMa1(rs.getString("nom_ma1"));
				ma.setApellidoMa1(rs.getString("ape_ma1"));
				cu.setNombreCurso(rs.getString("nom_cu"));
				cu.setHorarioCurso(rs.getNString("horario"));
				
				asignacion.setCurso(cu);
				asignacion.setMaestro(ma);
				asignacion.setIdAsignacion(rs.getInt("id_asignacion_ma"));
				
				return asignacion;
			}
		});
	}

	
	@Override
	public void save(AsignacionMae AsignacionMae) {
		String sql =  "INSERT INTO asignacion_ma" + "(id_maestro ,id_curso) VALUES (?,?)";
		jdbcTemplate.update(sql, new Object[] {AsignacionMae.getMaestro().getIdMa() , AsignacionMae.getCurso().getIdCurso()});	
	}

	
	@Transactional(readOnly = true)
	@Override
	public AsignacionMae findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM asignacion_ma WHERE id_asignacion_ma = ?";
		jdbcTemplate.update(sql, new Object[] {id});
	}


}
