import Layout from '@components/layout';
import Instagram from '@components/sections/instagram';
import styled from 'styled-components';
import ToggleViewSidebarProject from "@components/posts-layout/toggle-view-sidebarProject";

const PostsListContainer = styled.div`
  margin-bottom: ${80 / 14}rem;
`;

const ProjectCategoryGrid = () => {
  return (
    <Layout title="Información publica | Proyectos">
      <PostsListContainer>
        <ToggleViewSidebarProject/>
      </PostsListContainer>
      <Instagram />
    </Layout>
  );
};

export default ProjectCategoryGrid;
