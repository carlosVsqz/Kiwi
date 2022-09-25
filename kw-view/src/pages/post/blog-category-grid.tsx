import Layout from '@components/layout';
import ToggleViewSidebar from '@components/posts-layout/toggle-view-sidebar';
import Instagram from '@components/sections/instagram';
import styled from 'styled-components';
import jsx from "@i18n/properties";

const PostsListContainer = styled.div`
  margin-bottom: ${80 / 14}rem;
`;

const BlogCategoryGrid = () => {
  return (
    <Layout title={jsx.layout.blogCategory}>
      <PostsListContainer>
        <ToggleViewSidebar />
      </PostsListContainer>
      <Instagram />
    </Layout>
  );
};

export default BlogCategoryGrid;
