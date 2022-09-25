import PostStardard from '@components/post/post-stardard';
import {AppState} from '@store';
import {isString} from 'lodash';
import Link from 'next/link';
import React from 'react';
import {useSelector} from 'react-redux';

const PostContentRelated = () => {
  const { data, fetching } = useSelector((state: AppState) => state.posts.related);

  if (!data?.length) return <></>;

  return !fetching ? (
    <div className="post-related">
      <div className="post-related-item -prev">
        <Link href="/p/[id]" as={`/p/${data[0]?.id}`}>
          <a href={`/p/${data[0]?.id}`}>
            <i className="fas fa-chevron-left"></i>Anterior
          </a>
        </Link>
        <div className="post-related-item__content">
          <img src={isString(data[0]?.image) ? data[0].image : ''} alt="Relate" />
          <PostStardard className="-left" data={data[0]} hideCover hideInfos />
        </div>
      </div>
      <div className="post-related-item -next">
        <Link href="/p/[id]" as={`/p/${data[1]?.id}`}>
          <a href={`/p/${data[1]?.id}`}>
            Siguiente<i className="fas fa-chevron-right"></i>
          </a>
        </Link>
        <div className="post-related-item__content">
          <PostStardard className="-right" data={data[1]} hideCover hideInfos />
          <img src={isString(data[1]?.image) ? data[1].image : ''} alt="Relate" />
        </div>
      </div>
    </div>
  ) : (
    <></>
  );
};

export default PostContentRelated;
