package org.khit.myapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.khit.myapp.dto.BoardDTO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository { // == BoardDAO 

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; //검색
	
	// 글쓰기 처리 >> controller에서 만들고 여기서 처리
	public void save(BoardDTO board) {
		
		conn = JDBCUtil.getConnection();
		String sql = "insert into boards(boardtitle, boardwriter, boardcontent) "
				+ "values(?, ?, ?)"; // springboot는 db가 없으므로 여기에 입력!
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardWriter());
			pstmt.setString(3, board.getBoardContent());
			
			//실행
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	} // save

	// 글 목록 list 
	public List<BoardDTO> getListAll() {
		List<BoardDTO> boardList = new ArrayList<>();
		
		conn = JDBCUtil.getConnection();
		String sql = "select * from boards order by id desc"; // springboot는 db가 없으므로 여기에 입력!
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 검색 할때는 executeQuery(), 수정 및 삭제는 executeUpdate()
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setId(rs.getLong("id"));
				board.setBoardTitle(rs.getString("boardtitle"));
				board.setBoardWriter(rs.getString("boardwriter"));
				board.setBoardContent(rs.getString("boardcontent"));
				board.setCreatedTime(rs.getTimestamp("createdtime"));
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		
		return boardList;
	}
	
	// 글 상세보기
	public BoardDTO findById(Long id) {
		BoardDTO board = new BoardDTO();
		
		conn = JDBCUtil.getConnection();
		String sql = "select * from boards where id=?"; // springboot는 db가 없으므로 여기에 입력!
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery(); // 검색 할때는 executeQuery(), 수정 및 삭제는 executeUpdate()
			
			while(rs.next()) {
				board.setId(rs.getLong("id"));
				board.setBoardTitle(rs.getString("boardtitle"));
				board.setBoardWriter(rs.getString("boardwriter"));
				board.setBoardContent(rs.getString("boardcontent"));
				board.setCreatedTime(rs.getTimestamp("createdtime"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return board;
	}
	
	// 글 삭제 처리
	public void delete(Long id) {
		conn = JDBCUtil.getConnection();
		String sql = "delete from boards where id=? "; // springboot는 db가 없으므로 여기에 입력!
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			//실행
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 글 수정 처리
	public void update(BoardDTO board) {
		
		conn = JDBCUtil.getConnection();
		String sql = "update boards set boardtitle=?, boardcontent=? where id=? "; // springboot는 db가 없으므로 여기에 입력!
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setLong(3, board.getId());
			
			//실행
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
}// BoardRepository
