package kr.or.nextit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.nextit.board.mapper.BoardMapper;
import kr.or.nextit.board.model.Board;

public class BoardUnitTest {

	@Test
	public void test() throws Exception {
		// 처음 프로젝트 실행될 때 application-context.xml파일이 로딩되는데
		// 테스트할 때 동일한 작업을 실행해주기 위해서
		ApplicationContext context = new GenericXmlApplicationContext("application-context.xml");
		BoardMapper mapper = context.getBean("boardMapper", BoardMapper.class);
		
		// 1. 현재 게시글의 총 갯수를 가져온다.
		int beforeCount = mapper.selectBoardCount(null);
		// 2. 게시글 등록
		Board board = new Board();
		board.setBo_content("테스트 게시판");
		board.setBo_title("테스트 게시판");
		board.setBo_type("BBS");
		board.setBo_writer("san");
		mapper.insertBoard(board);
		
		// 3. 등록후 게시글의 총 갯수 구하기
		int afterCount = mapper.selectBoardCount(null);
		
		// 테스트
		assertThat(beforeCount, is(afterCount-1));
	}
	
//	@Test
//	public void updateTest() throws Exception {
//		// 처음 프로젝트 실행될 때 application-context.xml파일이 로딩되는데
//		// 테스트할 때 동일한 작업을 실행해주기 위해서
//		ApplicationContext context = new GenericXmlApplicationContext("application-context.xml");
//		BoardMapper mapper = context.getBean("boardMapper", BoardMapper.class);
//		
//		// 1. 게시글 조회(글번호로)
//		// 2. 글번호에 해당하는 게시글 수정
//		// 3. 글번호로 게시글조회한 값과 수정할 때 입력된 값을 비교
//		
//		Board board = new Board();
//		board.setBo_seq_no(1);
//		board = mapper.selectBoard(board.getBo_seq_no());
//		board.getBo_content();
//		board = mapper.selectBoard(board.getBo_seq_no());
//		board.setBo_content("수정된 데이터");
//		int afterBoard = mapper.updateBoard(board);		
//	}

}
