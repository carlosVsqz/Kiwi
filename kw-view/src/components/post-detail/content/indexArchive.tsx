import React, {useEffect} from 'react';
import parse from 'html-react-parser';
import dummyData from './hystory';

import PostContentAuthor from './author';
import Socials from '@components/other/socials';
import PostContentRelated from './related';
import PostCommentComments from './comments';
import PostTagsGroup from './tags';
import {useDispatch, useSelector} from 'react-redux';
import {AppState} from '@store';
import {handleGetRelatedArchives} from "@store/thunk/archive";

interface DocDetailContentProps {
  content?: string;
}

const ArchiveDetailContent = ({ content }: DocDetailContentProps) => {
  const dispatch = useDispatch();
  const { fetching, data } = useSelector((state: AppState) => state.posts.detail);

  useEffect(() => {
    dispatch(handleGetRelatedArchives({ _limit: 2, type_like: 'image' }));
  }, []);

  return (
    <div className="post-standard__content">
      <div id="post-share">
        {/*<h5>Compartir:</h5>*/}
        <Socials spacing={10} height={50} width={50} variant="contained" size="small" shape="circle" color="light" />
      </div>
      {parse(content || dummyData)}
      <div className="post-footer">
        {/*<PostTagsGroup />*/}
        {/*<PostContentAuthor avatar={data?.user.avatar} name={data?.user.fullName || ''} bio={data?.user.bio} />*/}
        <br/>
        <br/><br/>
        {/*<PostContentRelated />*/}
        <PostCommentComments />
      </div>
    </div>
  );
};

export default ArchiveDetailContent;
