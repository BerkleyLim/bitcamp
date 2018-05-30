package bitcamp.java106.pms.web;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;

@Component("/team/member")
public class TeamMemberController {

    TeamMemberDao teamMemberDao;
    TeamDao teamDao;
    MemberDao memberDao;
    
    public TeamMemberController(TeamMemberDao teamMemberDao, TeamDao teamDao,
            MemberDao memberDao) {
        this.teamMemberDao = teamMemberDao;
        this.teamDao = teamDao;
        this.memberDao = memberDao;
    }
    
    
    @RequestMapping("/list")
    public String list(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");

        List<Member> members = teamMemberDao.selectListWithEmail(name);
        request.setAttribute("members", members);
        return "/team/member/list.jsp";
    }
    
    @RequestMapping("/add")
    public String add(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        String teamName = request.getParameter("teamName");
        String memberId = request.getParameter("memberId");
        
        Team team = teamDao.selectOne(teamName);
        if (team == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }
        Member member = memberDao.selectOne(memberId);
        if (member == null) {
            throw new Exception(memberId + " 회원은 없습니다.");
        }
        if (teamMemberDao.isExist(teamName, memberId)) {
            throw new Exception("이미 등록된 회원입니다.");
        }
        teamMemberDao.insert(teamName, memberId);
        return "redirect:../view.do?name=" + 
                URLEncoder.encode(teamName, "UTF-8");
        // 개발자가 요청이나 응답헤더를 직접 작성하여 값을 주고 받으로 한다면,
        // URL 인코딩과 URL 디코딩을 손수 해 줘야 한다.
    }
    
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        String teamName = request.getParameter("teamName");
        String memberId = request.getParameter("memberId");
        
        int count = teamMemberDao.delete(teamName, memberId);
        if (count == 0) {
            throw new Exception("<p>해당 팀원이 존재하지 않습니다.</p>");
        }
        return "redirect:../view.do?name=" + 
                URLEncoder.encode(teamName, "UTF-8");
        // 개발자가 요청이나 응답헤더를 직접 작성하여 값을 주고 받으로 한다면,
        // URL 인코딩과 URL 디코딩을 손수 해 줘야 한다.
        
    }
    
}

//ver 47 - 애노테이션을 적용하여 요청 핸들러 다루기
//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 39 - forward 적용
