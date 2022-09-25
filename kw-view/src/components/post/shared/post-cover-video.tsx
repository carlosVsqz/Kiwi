import {PostItem} from '@store/slices/posts';
import React from 'react';
import {BaseReactPlayerProps} from 'react-player/base';

const PostCoverVideo = ({ data, ...props }: { data: PostItem } & BaseReactPlayerProps) => {
  return (
    <div className="card-cover">
      <div className="player-wrapper">
        {/*<ReactPlayer className="react-player" controls url={data.video} {...props} />*/}
      </div>
    </div>
  );
};

export default PostCoverVideo;
