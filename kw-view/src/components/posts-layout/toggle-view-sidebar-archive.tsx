import {ThemeVariation} from '@common/enum';
import Loading from '@components/other/loading';
import Pagination from '@components/other/pagination';
import {AppState} from '@store';
import React, {useEffect, useState} from 'react';
import Masonry from 'react-masonry-css';
import {useDispatch, useSelector} from 'react-redux';
import styled from 'styled-components';
import {PostView} from './shared/posts-header-bar';
import {PostInfo} from '@components/post/shared';
import Breadcrumb, {BreadcrumbItem} from '@components/other/breadcrumb';
import PostStandardArchive from "@components/post/post-stardard-archive";
import PostStardardFullArchive from "@components/post/post-stardard-full-archive";
import {handleGetArchives} from "@store/thunk/archive";
import ArchivesListSidebar from "@components/posts-layout/shared/archives-list-sidebar";
import ArchivesHeaderBar from "@components/posts-layout/shared/archives-header-bar";

const PostsContainer = styled.div`margin-bottom: ${50 / 14}rem;`;

const StyledPostStardardArchive = styled(PostStandardArchive)`margin-bottom: ${60 / 14}rem;`;

const StyledPostStardardFullArchive = styled(PostStardardFullArchive)`margin-bottom: ${20 / 14}rem;`;

const ToggleViewSidebarArchive = ({
  theme,
  defaultView,
  authorView,
}: {
  theme?: ThemeVariation;
  defaultView?: PostView;
  authorView?: boolean;
}) => {
  const PAGE_SIZE = 6;
  const dispatch = useDispatch();
  const types = 'image|slide|split';

  const [currentPage, setCurrentPage] = useState<number>(1);
  const [currentView, setCurrentView] = useState<PostView>(defaultView || PostView.Grid);

  const {data, fetching, meta} = useSelector((state: AppState) =>
    authorView ? state.author.archive : state.archives.list,
  );

  useEffect(() => {
    !authorView && dispatch(handleGetArchives({ _limit: PAGE_SIZE, _page: currentPage, type_like: types }));
  }, [currentPage]);

  const breakpointColumnsObj = {
    default: 2,
    768: 1,
    576: 1,
  };

  return (
    <div className="blog-toggle-view">
      <div className="container">
        <div className="row">
          <div className="col-12 col-md-5 col-lg-4 order-md-2">
            <ArchivesListSidebar theme={theme} />
          </div>
          <div className="col-12 col-md-7 col-lg-8 order-md-1">
            <Breadcrumb>
              <BreadcrumbItem href="/" startIcon={<i className="fas fa-home"></i>}>
                Inicio
              </BreadcrumbItem>
              <BreadcrumbItem href="/transparencia/general">Información publica</BreadcrumbItem>
              <BreadcrumbItem>SINACIG</BreadcrumbItem>
            </Breadcrumb>
            <ArchivesHeaderBar currentView={currentView} getCurrentView={setCurrentView} />
            {fetching ? (
              <Loading theme={theme} />
            ) : currentView === PostView.Row ? (
              <PostsContainer>
                {data?.map((item) => (
                  <StyledPostStardardFullArchive
                    infos={[PostInfo.User, PostInfo.Comment]}
                    className="-small -horizontal -row"
                    theme={theme}
                    data={item}
                    hideButton
                  />
                ))}
              </PostsContainer>
            ) : (
              <PostsContainer>
                <Masonry
                  breakpointCols={breakpointColumnsObj}
                  className="masonry-grid"
                  columnClassName="masonry-grid_column">
                  {data?.map((item) => (
                    <StyledPostStardardArchive className="-center -grid" theme={theme} data={item} />
                  ))}
                </Masonry>
              </PostsContainer>
            )}
            <Pagination
              onPageChange={(p) => setCurrentPage(p.selected + 1)}
              pageCount={meta?.pageCount || 1}
              initialPage={0}
              currentPage={currentPage}
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default ToggleViewSidebarArchive;
